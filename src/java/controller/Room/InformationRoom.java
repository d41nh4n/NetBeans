/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Room;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.HistoryReceiveMoney;
import model.NumberUser;
import model.Room;

/**
 *
 * @author Dai Nhan
 */
@WebServlet(name = "InformationRoomServlet", urlPatterns = {"/inforroom"})
public class InformationRoom extends HttpServlet {

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
            out.println("<title>Servlet InformationRoom</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InformationRoom at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("roomnum");
        if (id != null) {
            Room room = new Room().getById(id);
            if (room.getUsingRoom() != null) {
                NumberUser numUser = new NumberUser().getByRoom(room);
                request.setAttribute("user", numUser);
                //get number day use
                Date dateOut = numUser.getUsingRoom().getDateout();
                Date dateIn = numUser.getUsingRoom().getDatein();
                long differenceInMilliseconds = dateOut.getTime() - dateIn.getTime();
                int daysUse = (int) (differenceInMilliseconds / (1000 * 60 * 60 * 24));
                
                if (daysUse > 27) {
                    request.setAttribute("status", "month");
                }

                //get history pay rent
                List<HistoryReceiveMoney> list = new HistoryReceiveMoney().getByRoom(id, dateIn, dateOut);
                request.setAttribute("list", list);
            }
            request.setAttribute("room", room);
            request.getRequestDispatcher("PageRoom/inforroom.jsp").forward(request, response);
        } else {
            response.sendRedirect("listroom");
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
