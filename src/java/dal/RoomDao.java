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
import java.util.List;
import model.Room;

/**
 *
 * @author Dai Nhan
 */
public class RoomDao extends DBContext implements DAOInterface {

    @Override
    public List<Room> getAll() {
        List<Room> rooms = new ArrayList<>();
        String sqlCommand = "SELECT r.RoomNum, r.Available, r.IdType, tr.Type, tr.PricePerMonth, tr.PricePerDay "
                + "FROM tblRoom r "
                + "INNER JOIN tblTypeRoom tr ON r.IdType = tr.IdType";
        try (PreparedStatement statement = connection.prepareStatement(sqlCommand); ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                Room room = new Room();
                room.setRoomNum(resultSet.getString("RoomNum"));
                room.setAvailable(resultSet.getBoolean("Available"));
                room.setIdType(resultSet.getInt("IdType"));
                room.setTypeName(resultSet.getString("Type"));
                room.setPricePerMonth(resultSet.getFloat("PricePerMonth"));
                room.setPricePerDay(resultSet.getFloat("PricePerDay"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public Room getById(String id) {
        String sqlCommand = "select RoomNum, Available ,r.IdType ,Type, PricePerDay, PricePerMonth  from tblRoom r inner join tblTypeRoom t on r.IdType = t.IdType where RoomNum = ?";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Room room = new Room(rs.getString("RoomNum"), rs.getBoolean("Available"), rs.getInt("IdType"), rs.getString("Type"), rs.getFloat("PricePerMonth"), rs.getFloat("PricePerDay"));
                return room;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    @Override
    public int insert(Object o) {
        // TODO: Implement this method
        return 0;
    }

    @Override
    public int delete(Object o) {
        // TODO: Implement this method
        return 0;
    }

    @Override
    public int update(Object o) {
        // TODO: Implement this method
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new RoomDao().getById("P101"));
    }
}
