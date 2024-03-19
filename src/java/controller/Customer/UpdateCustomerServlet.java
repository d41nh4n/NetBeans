/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Customer;

import API.ApiCountry;
import Utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import model.Customer;

/**
 *
 * @author Dai Nhan
 */
@WebServlet(name = "UpdateCustomerServlet", urlPatterns = {"/updatecustomer"})
public class UpdateCustomerServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateCustomerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCustomerServlet at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("ID");
        Customer customer = new Customer();
        Customer cus = customer.getById(id);
        request.setAttribute("countries", ApiCountry.countries);
        request.setAttribute("customer", cus);
        request.getRequestDispatcher("PageCustomer/updatecustomer.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        String fullName = request.getParameter("fullname");
        String dob = request.getParameter("dob");
        boolean sex = Utils.parseBooleanParameter(request.getParameter("sex"));
        String phone = request.getParameter("phone");
        String id = request.getParameter("id");
        String nationality = request.getParameter("nationality");
        if (!isValidName(fullName)) {
            // Tên không hợp lệ
            request.setAttribute("notice", "Invalid name! Please enter a valid name. The name cannot contain special characters or numbers");
            request.setAttribute("fullname", fullName); // Truyền lại giá trị đã nhập cho trường fullname
            Customer customer = new Customer(fullName, Date.valueOf(dob), sex, phone, id, nationality);
            request.setAttribute("customer", customer);
            request.setAttribute("countries", ApiCountry.countries);
            request.getRequestDispatcher("PageCustomer/updatecustomer.jsp").forward(request, response);
            return;
        }

        if (!sex) {
            request.setAttribute("notice", "Sex is required! Please select a gender.");
            request.setAttribute("fullname", fullName);
            Customer customer = new Customer(fullName, Date.valueOf(dob), sex, phone, id, nationality);
            request.setAttribute("customer", customer);
            request.setAttribute("countries", ApiCountry.countries);
            request.getRequestDispatcher("PageCustomer/updatecustomer.jsp").forward(request, response);
            return;
        }

        if (!isValidId(id)) {
            request.setAttribute("notice", "Invalid Id! Please enter a valid id. Id numbers cannot contain alphanumeric characters");
            request.setAttribute("fullname", fullName);
            Customer customer = new Customer(fullName, Date.valueOf(dob), sex, phone, id, nationality);
            request.setAttribute("customer", customer);
            request.setAttribute("countries", ApiCountry.countries);
            request.getRequestDispatcher("PageCustomer/updatecustomer.jsp").forward(request, response);
            return;
        }
        if (!isValidPhone(phone)) {
            request.setAttribute("notice", "Invalid phone number! Please enter a valid phone number. Phone numbers cannot contain alphanumeric characters");
            request.setAttribute("fullname", fullName);
            Customer customer = new Customer(fullName, Date.valueOf(dob), sex, phone, id, nationality);
            request.setAttribute("customer", customer);
            request.setAttribute("countries", ApiCountry.countries);
            request.getRequestDispatcher("PageCustomer/updatecustomer.jsp").forward(request, response);
            return;
        }

        Customer customer = new Customer(fullName, Date.valueOf(dob), sex, phone, id, nationality);
        customer.update(customer);
        request.setAttribute("notice", "Update Customer success!");
        response.sendRedirect("listcustomer");
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

    private boolean isValidPhone(String phone) {
        return phone != null && !phone.trim().isEmpty() && phone.matches("\\d+");
    }

    private boolean isValidId(String id) {
        return id != null && !id.trim().isEmpty() && id.matches("\\d+");
    }

    private boolean isValidName(String fullName) {
        return fullName != null && !fullName.trim().isEmpty() && fullName.matches("[\\p{L} ]+");
    }
}
