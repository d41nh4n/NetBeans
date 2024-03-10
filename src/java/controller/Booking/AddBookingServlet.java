/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Booking;

import Utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import model.Booking;
import model.HistoryReceiveMoney;

/**
 *
 * @author Dai Nhan
 */
@WebServlet(name = "AddBookingServlet", urlPatterns = {"/addbooking"})
public class AddBookingServlet extends HttpServlet {

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
            out.println("<title>Servlet AddBookingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddBookingServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("PageBooking/addbooking.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String roomNumber = request.getParameter("roomNumber");
        String dateIn = request.getParameter("dateIn");
        String dateOut = request.getParameter("dateOut");
        String currentDate = request.getParameter("currentDateInput");
        float deposit = Utils.parseFloatParameter(request.getParameter("deposit"));
        String contact = request.getParameter("contact");
        //check booking
        Booking booking = new Booking(Utils.randomIdBooking(roomNumber), customerName, roomNumber,
                Date.valueOf(dateIn),
                Date.valueOf(dateOut),
                Date.valueOf(currentDate),
                deposit,
                contact);
        if (Utils.checkDateInOfRoom(booking)) {
            //add booking
            booking.insert(booking);
            //add history receive money
            HistoryReceiveMoney historyReceiveMoney = new HistoryReceiveMoney(0, roomNumber, Date.valueOf(currentDate), deposit, " Receive Deposit", "admin");
            historyReceiveMoney.insert(historyReceiveMoney);
            response.sendRedirect("listbooking");
        } else {
            request.setAttribute("customerName", customerName);
            request.setAttribute("roomNumber", roomNumber);
            request.setAttribute("dateIn", dateIn);
            request.setAttribute("dateOut", dateOut);
            request.setAttribute("deposit", deposit);
            request.setAttribute("contact", contact);
            request.setAttribute("error", "There is an error in the check-in date or check-out date, please check again");
            request.getRequestDispatcher("PageBooking/addbooking.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
