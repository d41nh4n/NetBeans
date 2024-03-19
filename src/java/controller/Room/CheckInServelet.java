/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Room;

import API.ApiCountry;
import Utils.Service;
import Utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Booking;
import model.Customer;
import model.NumberUser;
import model.Room;
import model.UsingRoom;

/**
 *
 * @author Dai Nhan
 */
@WebServlet(name = "CheckInServlet", urlPatterns = {"/checkin"})
public class CheckInServelet extends HttpServlet {

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
            out.println("<title>Servlet CheckInServelet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckInServelet at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("selectedCustomer");
        List<Customer> users;
        List<Room> room = new Room().getAll();
        HttpSession session = request.getSession();
        if (session.getAttribute("users") == null) {
            users = new ArrayList<>();
        } else {
            users = (List<Customer>) session.getAttribute("users");
        }
        Customer selectedCustomer = new Customer().getById(id);

        if (selectedCustomer != null) {
            users.add(selectedCustomer);
        }
        session.setAttribute("users", users);
        request.setAttribute("room", room);
        request.getRequestDispatcher("PageRoom/addroom.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        String id = request.getParameter("roomnum");
        // get information of User
        ArrayList<Customer> customers = (ArrayList<Customer>) session.getAttribute("users");

        // get information of check-in bill
        Date datein = Utils.convertStringToDate(request.getParameter("datein"));
        Date dateout = Utils.convertStringToDate(request.getParameter("dateout"));
        float deposite = Utils.parseFloatParameter(request.getParameter("deposit"));
        float priceTotal = Service.countTotalPrice(datein, dateout, id);
        // create object mapped to room is used (set 0 to ensure data accuracy)
        UsingRoom usingRoom = new UsingRoom(id, 0, datein, dateout, deposite, priceTotal);

        //check date-in, date-out
        if (Utils.checkDateInUsingRoom(usingRoom)) {
            usingRoom.insert(usingRoom);
            // create relation between UsingRoom and Customer
            NumberUser users = new NumberUser(customers, usingRoom);
            users.insert(users);
            //check that check-in from booking or not 
            Booking b = (Booking) session.getAttribute("booking");
            if (b != null) {
                b.delete(b);
            }
            session.removeAttribute("roomnum");
            session.removeAttribute("users");
            session.removeAttribute("booking");
            response.sendRedirect("listroom");
        } else {
            request.getRequestDispatcher("PageRoom/addroom.jsp").forward(request, response);
        }
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
