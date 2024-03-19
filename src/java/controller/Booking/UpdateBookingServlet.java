/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Booking;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Booking;
import Utils.Utils;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import model.HistoryReceiveMoney;
import model.Room;

/**
 *
 * @author Dai Nhan
 */

@WebServlet(name = "UpdateBookingServlet", urlPatterns = {"/updatebooking"})
public class UpdateBookingServlet extends HttpServlet {

    public static final Date NOW = Date.valueOf(LocalDateTime.now().toLocalDate());

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
            out.println("<title>Servlet UpdateBookingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateBookingServlet at " + request.getContextPath() + "</h1>");
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
        Booking b = new Booking();
        String id = request.getParameter("ID");
        if (b.getById(id) == null) {
            response.sendRedirect("listbooking");
        } else {
            request.setAttribute("booking", b.getById(id));
            List<Room> room = new Room().getAll();
            request.setAttribute("room", room);
            request.getRequestDispatcher("PageBooking/updatebooking.jsp").forward(request, response);
        }
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
        Booking b = new Booking();

        String id = (request.getParameter("Id"));
        String customerName = request.getParameter("customerName");
        String roomNumber = request.getParameter("roomNumber");
        String dateIn = request.getParameter("dateIn");
        String dateOut = request.getParameter("dateOut");
        float deposite = Utils.parseFloatParameter(request.getParameter("deposite"));
        String contact = request.getParameter("contact");

        Booking booking = new Booking(id, customerName, roomNumber,
                Date.valueOf(dateIn),
                Date.valueOf(dateOut), NOW,
                deposite, contact); 

            b.update(booking);
            response.sendRedirect("listbooking");
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
