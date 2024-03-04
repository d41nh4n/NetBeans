 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import DBConnection.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.NumberUser;
import model.UsingRoom;

/**
 *
 * @author Dai Nhan
 */
public class NumberUserDao extends DBContext {

    public int insert(NumberUser numberUser) {
        String sqlCommand = "INSERT INTO tblNumberUser (IdCustomer, RoomNum) VALUES (?, ?)";

        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            for (Customer customer : numberUser.getCustomers()) {
                st.setString(1, customer.getId());
                st.setString(2, numberUser.getUsingRoom().getRoomNum());
                st.addBatch();
            }

            int[] rowsAffected = st.executeBatch();
            int totalRowsAffected = 0;

            for (int row : rowsAffected) {
                if (row <= 0) {
                    return -1;
                } else {
                    totalRowsAffected += row;
                }
            }

            return totalRowsAffected;
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Error inserting booking", e);
            return -1;
        }
    }

//    public int update(NumberUser numberUser) {
//        String sqlCommand = "UPDATE tblNumberUser SET RoomNum = ? WHERE IdCustomer = ?";
//
//        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
//            st.setString(1, numberUser.getUsingRoom().getRoomNum());
//            st.setString(2, numberUser.getCustomers().get(0).getId()); // Lấy IdCustomer của người đầu tiên
//
//            int rowsAffected = st.executeUpdate();
//
//            return rowsAffected;
//        } catch (SQLException e) {
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Error updating booking", e);
//            return -1;
//        
    public int delete(String roomNum) {
        String sqlCommand = "DELETE FROM tblNumberUser WHERE RoomNum = ?";

        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setString(1, roomNum);

            int rowsAffected = st.executeUpdate();

            return rowsAffected;
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Error deleting booking", e);
            return -1;
        }
    }

    public NumberUser getByRoomNumber(String roomNumber) {
        String sqlCommand = "SELECT IdCustomer, RoomNum FROM tblNumberUser WHERE RoomNum = ?";
        NumberUser numberUser = new NumberUser();

        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setString(1, roomNumber);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    // get Customer by id and add in NumberUser
                    String idCustomer = rs.getString("IdCustomer");
                    Customer customer = new Customer().getById(idCustomer);
                    numberUser.addCustomer(customer);
                    // getUsingRom by id and add in NumberUser
                    if (numberUser.getUsingRoom() == null) {
                        UsingRoom usingRoom = new UsingRoom().getById(roomNumber);
                        numberUser.setUsingRoom(usingRoom);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Error getting booking by RoomNum", e);
        }

        return numberUser;
    }

    public static void main(String[] args) {
        // Tạo danh sách khách hàng
        Date date = new Date(2003, 10, 29);
       Customer cus = new Customer("John Doe", date, true, "123456789", "092151523154", "American");
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(cus);
        
        // Tạo đối tượng UsingRoom
        UsingRoom usingRoom = new UsingRoom("P101", 0, date, date, 100.0f, 200.0f);
        // Tạo đối tượng NumberUser
        NumberUser numberUser = new NumberUser(customers, usingRoom);

        // In thông tin của NumberUser
//        System.out.println("NumberUser information:");
//        System.out.println("Using Room Number: " + numberUser.getUsingRoom().getRoomNum());
//        System.out.println("Number of Customers: " + numberUser.getCustomers().size());
//        System.out.println("List of Customers:");
//        for (int i = 0; i < numberUser.getCustomers().size(); i++) {
//            Customer customer = numberUser.getCustomers().get(i);
//            System.out.println("Customer " + (i + 1) + ": " + customer.getFullName() + ", " + customer.getDob()
//                    + ", " + customer.isSex() + ", " + customer.getPhone() + ", " + customer.getId()
//                    + ", " + customer.getNationality());

//        }
            
                
        System.out.println(numberUser.delete(numberUser));
    }
}
