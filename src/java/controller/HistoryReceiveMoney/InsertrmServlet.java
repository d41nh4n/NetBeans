/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.HistoryReceiveMoney;

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
import java.time.LocalDateTime;
import model.Account;
import model.History;
import model.HistoryReceiveMoney;
import model.Room;
import model.UsingRoom;

/**
 *
 * @author Dai Nhan
 */
@WebServlet(name = "InsertHRServlet", urlPatterns = {"/insertrm"})
public class InsertrmServlet extends HttpServlet {

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
            out.println("<title>Servlet InsertHRServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertHRServlet at " + request.getContextPath() + "</h1>");
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

        String decription = request.getParameter("description");
        String total = request.getParameter("total");
        String[] decrip = decription.split("_");
        String numRoom = decrip[1];
        String status = decrip[0];
        String numberPart = total.replaceAll("[^0-9.]", ""); // Loại bỏ tất cả các ký tự không phải số
        float number = Utils.parseFloatParameter(numberPart) * 25000;
        HttpSession session = request.getSession();
        Account ac = (Account) session.getAttribute("manager");
        HistoryReceiveMoney his = new HistoryReceiveMoney(0, numRoom, NOW, number, status, ac.getUserName());
        his.insert(his);
        response.sendRedirect("inforroom?roomnum=" + numRoom);
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
        String roomNum = request.getParameter("roomnum");
        float totalPayed = Utils.parseFloatParameter(request.getParameter("totalPayed"));
        String user = request.getParameter("manager");
        String status = request.getParameter("status");
        float money = 0f;
        if (action == "Month") {
            money += new Room().getById(roomNum).getPricePerMonth();
        } else {
            money += totalPayed;
        }
        switch (action) {
            case "paypal":
                if (totalPayed >= new UsingRoom().getById(roomNum).getPriceTotal()) {
                    response.sendRedirect("inforroom?roomnum=" + roomNum);
                } else {
                    request.setAttribute("roomNum", roomNum);
                    request.setAttribute("money", money / 25000);
                    request.getRequestDispatcher("PayPal/chekout.jsp").forward(request, response);
                }
                break;
            case "cash":
                if (totalPayed >= new UsingRoom().getById(roomNum).getPriceTotal()) {
                    response.sendRedirect("inforroom?roomnum=" + roomNum);
                } else {
                    HistoryReceiveMoney his = new HistoryReceiveMoney(0, roomNum, NOW, money, status + " room fee", user);
                    his.insert(his);
                    response.sendRedirect("inforroom?roomnum=" + roomNum);
                }
                break;
            default:
                throw new AssertionError();
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
