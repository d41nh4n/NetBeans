/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package Filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Employee;

/**
 *
 * @author Dai Nhan
 */
@WebFilter(filterName = "AuthenFiler", urlPatterns = {"/*"})
public class AuthenFiler implements Filter {

    private static final int US = 2;
    private static final int AD = 1;
    private static final String LOGIN_PAGE = "login.jsp";
    private static final List<String> ADMIN_FUNC = new ArrayList<>();
    private static final List<String> USER_FUNC = new ArrayList<>();
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public AuthenFiler() {
        USER_FUNC.add("updateusingroom");
        USER_FUNC.add("addusingroom");
        USER_FUNC.add("deleteusingroom");
        USER_FUNC.add("listusingroom");
        USER_FUNC.add("checkin");
        USER_FUNC.add("editroom");
        USER_FUNC.add("checkio");
        USER_FUNC.add("inforroom");
        USER_FUNC.add("listroom");
        USER_FUNC.add("addcus");
        USER_FUNC.add("addcustomer");
        USER_FUNC.add("listcustomer");
        USER_FUNC.add("seachbyajax");
        USER_FUNC.add("updatecustomer");
        USER_FUNC.add("addbooking");
        USER_FUNC.add("cancelbooking");
        USER_FUNC.add("listbooking");
        USER_FUNC.add("updatebooking");
        USER_FUNC.add("listbooking");
        USER_FUNC.add("listbooking");
        USER_FUNC.add("listbooking");
        USER_FUNC.add("listbooking");
        USER_FUNC.add("listbooking");
    }
    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("LoginFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("LoginFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        String resource = uri.substring(uri.lastIndexOf("/") + 1); // Lấy tên resource từ URI

        // Tối ưu hóa điều kiện kiểm tra URI
        if (uri.endsWith(".jpg") || uri.endsWith(".png")) {
            chain.doFilter(request, response);
            return;
        }

        // Kiểm tra trang đăng nhập và các servlet liên quan
        if (uri.contains(LOGIN_PAGE) || resource.equals("login") || resource.equals("logingoogle")) {
            chain.doFilter(request, response);
            return;
        }

        // Kiểm tra session
        HttpSession session = req.getSession(false); // Không tạo mới session nếu không tồn tại
        if (session == null || session.getAttribute("manager") == null && (!resource.contains("register") || !resource.contains("register.jsp"))) {
            res.sendRedirect("login");
            return;
        }

        // Kiểm tra quyền truy cập của user
        Account user = (Account) session.getAttribute("manager");
        int roleID = user.getRole();
        if ((roleID == US && user.isStatus() && USER_FUNC.contains(resource))) {
            chain.doFilter(request, response);
        } else if (roleID == AD && user.isStatus()) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect("login");
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("LoginFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("LoginFilter()");
        }
        StringBuffer sb = new StringBuffer("LoginFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
