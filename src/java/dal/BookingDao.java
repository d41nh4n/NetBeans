/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import DBConnection.DBContext;
import Interface.DAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Booking;

/**
 *
 * @author Dai Nhan
 */
public class BookingDao extends DBContext implements DAOInterface<Booking> {

    public BookingDao() {
    }

    @Override
    public List<Booking> getAll() {
        //Take all data from table booking
        List<Booking> listBooking = new ArrayList<>();

        String sqlCommand = "select * from tblBooking";
        try {
            PreparedStatement st = connection.prepareStatement(sqlCommand);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                listBooking.add(new Booking(rs.getString("Id"),
                        rs.getString("CustomerName"),
                        rs.getString("RoomNumber"),
                        rs.getDate("DateIn"),
                        rs.getDate("DateOut"),
                        rs.getDate("ExecDate"),
                        rs.getFloat("Deposit"),
                        rs.getString("Contact")));
            }
        } catch (Exception e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            close();
        }
        return listBooking;
    }

    @Override
    public Booking getById(String id) {
        //Take data of booking table by id

        String sqlCommand = "select * from tblBooking where Id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sqlCommand);
            st.setString(1, (id));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Booking booking = new Booking(
                        rs.getString("Id"),
                        rs.getString("CustomerName"),
                        rs.getString("RoomNumber"),
                        rs.getDate("DateIn"),
                        rs.getDate("DateOut"),
                        rs.getDate("ExecDate"),
                        rs.getFloat("Deposit"),
                        rs.getString("Contact")
                );
                return booking;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            close();
        }
        return null;
    }

    @Override
    public int insert(Booking booking) {
        String sqlCommand = "INSERT INTO tblBooking (Id,CustomerName, RoomNumber, DateIn, DateOut, ExecDate, Deposit, Contact)"
                + "VALUES(?,?,?,?,?,?,?,?)";

        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setString(1, booking.getId());
            st.setString(2, booking.getCustomerName());
            st.setString(3, booking.getRoomNumber());
            st.setDate(4, booking.getDateIn());
            st.setDate(5, booking.getDateOut());
            st.setDate(6, booking.getExecDate());
            st.setFloat(7, booking.getDeposite());
            st.setString(8, booking.getContact());

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0 ? 1 : 0;
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Error inserting booking", e);
        }
        return 0;
    }

    //Delete data from table Booking 
    @Override
    public int delete(Booking booking) {
        String sqlCommand = "DELETE FROM tblBooking WHERE Id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sqlCommand)) {
            statement.setString(1, booking.getId());

            // Execute the DELETE statement
            int rowsAffected = statement.executeUpdate();

            // If at least one row is affected, return true
            return rowsAffected > 0 ? 1 : 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Booking o) {
        int rowsAffected = 0;
        String updateCommand = "UPDATE tblBooking SET "
                + "CustomerName = ?, "
                + "RoomNumber = ?, "
                + "DateIn = ?, "
                + "DateOut = ?, "
                + "ExecDate = ?, "
                + "Deposit = ?, "
                + "Contact = ? "
                + "WHERE Id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(updateCommand);

            st.setString(1, o.getCustomerName());
            st.setString(2, o.getRoomNumber());
            st.setDate(3, (o.getDateIn()));
            st.setDate(4, (o.getDateOut()));
            st.setDate(5, (o.getExecDate()));
            st.setFloat(6, o.getDeposite());
            st.setString(7, o.getContact());
            st.setString(8, o.getId());

            rowsAffected = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }
     public static void main(String[] args) {
        // Tạo một đối tượng Booking mới
        Booking booking = new Booking();
        booking.setId("1");
        booking.setCustomerName("John Doe");
        booking.setRoomNumber("P101");
        booking.setDateIn(Date.valueOf("2024-03-01"));
        booking.setDateOut(Date.valueOf("2024-03-15"));
        booking.setExecDate(Date.valueOf("2024-03-01"));
        booking.setDeposite(100.0f);
        booking.setContact("john.doe@example.com");

        // Tạo một đối tượng BookingDao và chèn đối tượng Booking vào cơ sở dữ liệu
        BookingDao bookingDao = new BookingDao();
        int result = bookingDao.insert(booking);

        // Kiểm tra kết quả của việc chèn
        if (result == 1) {
            System.out.println("Booking inserted successfully.");
        } else {
            System.out.println("Failed to insert booking.");
        }
    }
}
