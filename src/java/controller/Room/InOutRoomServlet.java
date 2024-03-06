/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Room;

import API.ApiCountry;
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
import model.Booking;
import model.Customer;
import model.NumberUser;
import model.Room;
import model.UsingRoom;

/**
 *
 * @author Dai Nhan
 */
@WebServlet(name = "InOutRoomServlet", urlPatterns = {"/checkio"})
public class InOutRoomServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateRoomServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateRoomServlet at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("index.html");
            return;
        }
        String roomNum = request.getParameter("roomnum");
        switch (action) {
            case "checkin" -> {
                if (new UsingRoom().getById(roomNum) == null) {
                    request.setAttribute("countries", ApiCountry.countries);
                    request.setAttribute("roomnum", roomNum);
                    request.getRequestDispatcher("PageRoom/addroom.jsp").forward(request, response);
                }
            }
            case "booking" -> {
                String idBooking = request.getParameter("ID");
                Booking booking = new Booking().getById(idBooking);
                HttpSession session = request.getSession();
                if (new UsingRoom().getById(booking.getRoomNumber()) == null) {
                    session.setAttribute("booking", booking);
                    request.setAttribute("countries", ApiCountry.countries);
                    request.getRequestDispatcher("PageRoom/addroom.jsp").forward(request, response);
                }
            }
            case "edit" -> {
                Room room = new Room().getById(roomNum);
                request.setAttribute("room", room);
                request.getRequestDispatcher("PageRoom/updateroom.jsp").forward(request, response);
            }

            case "checkout" -> {
                //delete NumberUser 
                Room room = new Room().getById(roomNum);
                NumberUser numberUser = new NumberUser().getByRoom(room);
                numberUser.delete(numberUser);

                //delete UsingRoom through model mapped
                UsingRoom usingRoom = new UsingRoom().getById(roomNum);
                usingRoom.delete(usingRoom);

                response.sendRedirect("listroom");
            }
            default ->
                response.sendRedirect("index.html");
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
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("tndex.html");
            return;
        }
        String id = request.getParameter("roomnum");
        switch (action) {
            case "checkin" -> {
                // get information of User
                int numberUser = Integer.parseInt(request.getParameter("numberuser"));

                ArrayList<Customer> customers = new ArrayList<>();

                for (int i = 1; i <= numberUser; i++) {

                    String idCus = request.getParameter("id" + i);

                    if (new Customer().getById(id) == null) {

                        String fullName = request.getParameter("firstName" + i) + " " + request.getParameter("lastName" + i);
                        String dob = request.getParameter("dob" + i);
                        boolean sex = Utils.parseBooleanParameter(request.getParameter("sex" + i));
                        String phone = request.getParameter("phone" + i);
                        String nationality = request.getParameter("nationality" + i);

                        Customer customer = new Customer(fullName, Date.valueOf(dob), sex, phone, idCus, nationality);
                        //add database
                        customer.insert(customer);
                        //add in room
                        customers.add(customer);
                    } else {
                        //add in room
                        customers.add(new Customer().getById(id));
                    }
                }

                // get information of check-in bill
                Date datein = Utils.convertStringToDate(request.getParameter("datein"));
                Date dateout = Utils.convertStringToDate(request.getParameter("dateout"));
                float deposite = Utils.parseFloatParameter(request.getParameter("deposite"));
                float priceTotal = Utils.parseFloatParameter(request.getParameter("priceTotal"));
                // create object mapped to room is used (set 0 to ensure data accuracy)
                UsingRoom usingRoom = new UsingRoom(id, 0, datein, dateout, deposite, priceTotal);
                usingRoom.insert(usingRoom);
                // create relation between UsingRoom and Customer
                NumberUser users = new NumberUser(customers, usingRoom);
                users.insert(users);

                response.sendRedirect("listroom");
            }

            case "edit" -> {
                //get information usingroom was changed
                Date dateout = Utils.convertStringToDate(request.getParameter("dateout"));
                float deposite = Utils.parseFloatParameter(request.getParameter("deposite"));
                float priceTotal = Utils.parseFloatParameter(request.getParameter("priceTotal"));
                // get object mapped from database
                UsingRoom usingRoom = new UsingRoom().getById(id);
                // change attribute
                usingRoom.setDateout(dateout);
                usingRoom.setDeposite(deposite);
                usingRoom.setPriceTotal(priceTotal);
                // update database throught object mapped
                usingRoom.update(usingRoom);

                response.sendRedirect("listroom");
            }
            default -> {
                response.sendRedirect("index.html");
            }
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
