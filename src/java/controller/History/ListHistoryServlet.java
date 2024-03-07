/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.History;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.History;

/**
 *
 * @author Dai Nhan
 */
@WebServlet(name = "ListHistoryServlet", urlPatterns = {"/listhistory"})
public class ListHistoryServlet extends HttpServlet {

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
            out.println("<title>Servlet ListHistoryServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListHistoryServlet at " + request.getContextPath() + "</h1>");
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
        String pageStr = request.getParameter("page");
        String choiceStr = request.getParameter("searchchoice");
        //check page
        int page;
        if (pageStr == null) {
            page = 1;
        } else {
            page = Integer.parseInt(pageStr);
        }
        //check choice
        StringBuilder seachChoice = new StringBuilder();
        if (choiceStr == null) {
            seachChoice.append("id");
            choiceStr = "id";
        } else {
            seachChoice.append(request.getParameter("searchchoice"));
        }
        int numberPage = numberPage(new History().count());
        List<History> list = new History().getByPage(page, seachChoice.toString());

        if (list.isEmpty()) {
            request.setAttribute("notice", "Data is emtpy!");
        } else {
            request.setAttribute("searchchoice", choiceStr);
            request.setAttribute("numberPage", numberPage);
            request.setAttribute("list", list);
        }
        request.getRequestDispatcher("PageHistory/listhistory.jsp").forward(request, response);
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

    private int numberPage(int numberData) {
        int numberPage = numberData / 10;
        if (numberData % 10 != 0) {
            numberPage++;
        }
        return numberPage;
    }
}
