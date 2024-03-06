/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Customer;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Customer;

/**
 *
 * @author Dai Nhan
 */
@WebServlet(name = "SearchByAjax", urlPatterns = {"/seachbyajax"})
public class SearchByAjax extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchByAjax</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchByAjax at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("txt");
        List<Customer> listC = null;
        if (id != null && !id.isEmpty()) {
            listC = new Customer().getListById(id);
        }
        PrintWriter out = response.getWriter();
        out.println("<form action=\"checkin\" method=\"GET\">");
        out.println("<div class=\"max-h-80 overflow-auto min-w-full\">");
        out.println("<table class=\"min-w-full divide-y divide-gray-200\">");
        for (Customer c : listC) {
            out.println("<tr class=\"text-sm\">");
            out.println("<td class=\"px-2 py-4 whitespace-nowrap\">");
            out.println("<input type=\"radio\" name=\"selectedCustomer\" value=\"" + c.getId() + "\">");
            out.println("</td>");
            out.println("<td class=\"px-2 py-4 whitespace-nowrap\">" + c.getId() + "</td>");
            out.println("<td class=\"px-2 py-4 whitespace-nowrap\">" + c.getFullName() + "</td>");
            out.println("<td class=\"px-2 py-4 whitespace-nowrap\">" + new SimpleDateFormat("MM-dd-yyyy").format(c.getDob()) + "</td>");
            out.println("<td class=\"px-2 py-4 whitespace-nowrap\">" + (c.isSex() ? "Male" : "Female") + "</td>");
            out.println("<td class=\"px-2 py-4 whitespace-nowrap\">" + c.getPhone() + "</td>");
            out.println("<td class=\"px-2 py-4 whitespace-nowrap\">" + c.getNationality() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.println("<input type=\"submit\" value=\"Apply\">");
        out.println("</form>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
