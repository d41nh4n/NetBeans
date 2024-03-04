/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import DBConnection.DBContext;
import Interface.DAOInterface;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UsingRoom;

/**
 *
 * @author Dai Nhan
 */
public class UsingRoomDao extends DBContext implements DAOInterface<UsingRoom> {

    @Override
    public List<UsingRoom> getAll() {
        List<UsingRoom> list = new ArrayList<>();

        String sqlCommand = "select * from tblUsingRoom";
        try {
            PreparedStatement st = connection.prepareStatement(sqlCommand);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                list.add(new UsingRoom(rs.getString("RoomNum"),
                        rs.getInt("NumberUser"),
                        rs.getDate("DateIn"),
                        rs.getDate("DateOut"),
                        rs.getFloat("Deposite"),
                        rs.getFloat("PriceTotal")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public UsingRoom getById(String id) {
        String sqlCommand = "select * from tblUsingRoom where RoomNum = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sqlCommand);

            st.setString(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new UsingRoom(rs.getString("RoomNum"),
                        rs.getInt("NumberUser"),
                        rs.getDate("DateIn"),
                        rs.getDate("DateOut"),
                        rs.getFloat("Deposite"),
                        rs.getFloat("PriceTotal"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(UsingRoom o) {
        String sqlCommand = "INSERT INTO tblUsingroom (RoomNum, NumberUser, DateIn, DateOut, Deposite, PriceTotal) " +
                            "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sqlCommand)){ 
            statement.setString(1, o.getRoomNum());
            statement.setInt(2, o.getNumberUser());
            statement.setDate(3, o.getDatein());
            statement.setDate(4, o.getDateout());
            statement.setFloat(5, o.getDeposite());
            statement.setFloat(6, o.getPriceTotal());

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0 ? 1 : 0;
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Error inserting booking", e);
        }
        return 0;
    }

    @Override
    public int delete(UsingRoom o) {
        String sqlCommand = "delete from tblUsingRoom where RoomNum = ?;";

        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setString(1, o.getRoomNum());
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0 ? 1 : 0;
        } catch (Exception e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Error inserting booking", e);
        }
        return 0;
    }

    @Override
    public int update(UsingRoom o) {
        String sqlCommand = "UPDATE tblUsingRoom SET NumberUser=?, DateIn=?, DateOut=?, Deposite=?, PriceTotal=? WHERE RoomNum=?";

        try (PreparedStatement statement = connection.prepareStatement(sqlCommand)) {
            statement.setInt(1, o.getNumberUser());
            statement.setDate(2, o.getDatein());
            statement.setDate(3, o.getDateout());
            statement.setFloat(4, o.getDeposite());
            statement.setFloat(5, o.getPriceTotal());
            statement.setString(6, o.getRoomNum());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0 ? 1 : 0;
        } catch (SQLException ex) {
            Logger.getLogger(UsingRoomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void main(String[] args) {
        // Khởi tạo đối tượng UsingRoomDao
        UsingRoomDao usingRoomDao = new UsingRoomDao();

        // Test phương thức getAll()
//        System.out.println("Testing getAll() method:");
//        List<UsingRoom> usingRooms = usingRoomDao.getAll();
//        for (UsingRoom usingRoom : usingRooms) {
//            System.out.println(usingRoom);
//        }
        // Test phương thức getById()
//        System.out.println("\nTesting getById() method:");
//        UsingRoom usingRoom = usingRoomDao.getById("P101");
//        System.out.println(usingRoom);

        // Test phương thức insert()
//        System.out.println("\nTesting insert() method:");
//        UsingRoom newUsingRoom = new UsingRoom("P104", 2, 
//                            java.sql.Date.valueOf("2024-03-01"), 
//                            java.sql.Date.valueOf("2024-03-15"), 
//                            100.0f, 500.0f);
//        int inserted = usingRoomDao.insert(newUsingRoom);
//        if (inserted == 1) {
//            System.out.println("Insertion successful!");
//        } else {
//            System.out.println("Insertion failed!");
//        }
//
//        // Test phương thức delete()
        System.out.println("\nTesting delete() method:");
        UsingRoom usingRoomToDelete = usingRoomDao.getById("P104");
        int deleted = usingRoomDao.delete(usingRoomToDelete);
        if (deleted == 1) {
            System.out.println("Deletion successful!");
        } else 
            System.out.println("Deletion failed!");{
        }
////
//        // Test phương thức update()
//        System.out.println("\nTesting update() method:");
//        UsingRoom usingRoomToUpdate = usingRoomDao.getById("existing_room_number_here");
//        usingRoomToUpdate.setNumberUser(3);
//        int updated = usingRoomDao.update(usingRoomToUpdate);
//        if (updated == 1) {
//            System.out.println("Update successful!");
//        } else {
//            System.out.println("Update failed!");
//        }
//    }
    }
}
