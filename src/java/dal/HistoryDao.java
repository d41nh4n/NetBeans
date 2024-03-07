/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import DBConnection.DBContext;
import model.History;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dai Nhan
 */
public class HistoryDao extends DBContext {

    public boolean createHistory(History history) {
        String query = "INSERT INTO tblHistory (RoomNum, NumberUser, DateIn, DateOut, TotalMoney) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, history.getRoomNum());
            ps.setInt(2, history.getNumberCus());
            ps.setDate(3, new java.sql.Date(history.getDateIn().getTime()));
            ps.setDate(4, new java.sql.Date(history.getDateOut().getTime()));
            ps.setFloat(5, history.getTotalMoney());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read
    public List<History> getAllHistory() {
        List<History> historyList = new ArrayList<>();
        String query = "SELECT * FROM tblHistory";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                History history = new History();
                history.setId(rs.getInt("Id"));
                history.setRoomNum(rs.getString("RoomNum"));
                history.setNumberCus(rs.getInt("NumberUser"));
                history.setDateIn(rs.getDate("DateIn"));
                history.setDateOut(rs.getDate("DateOut"));
                history.setTotalMoney(rs.getFloat("TotalMoney"));
                historyList.add(history);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historyList;
    }

    // Get By Id
    public History getById(int id) {
        String sqlCommand = "SELECT * FROM tblHistory WHERE Id=?";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setInt(1, id);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new History(rs.getInt("Id"), rs.getString("RoomNum"), rs.getInt("NumberUser"), rs.getDate("DateIn"), rs.getDate("DateOut"), rs.getFloat("TotalMoney")); // Replace null with appropriate HistoryNumberUser instance if available
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update
    public boolean updateHistory(History history) {
        String query = "UPDATE tblHistory SET RoomNum=?, NumberUser=?, DateIn=?, DateOut=?, TotalMoney=? WHERE Id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, history.getRoomNum());
            ps.setInt(2, history.getNumberCus());
            ps.setDate(3, new java.sql.Date(history.getDateIn().getTime()));
            ps.setDate(4, new java.sql.Date(history.getDateOut().getTime()));
            ps.setFloat(5, history.getTotalMoney());
            ps.setInt(6, history.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete
    public boolean deleteHistory(int id) {
        String query = "DELETE FROM tblHistory WHERE Id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<History> getByPage(int offset, String sortCriteria) {
        List<History> historyList = new ArrayList<>();
        String sqlCommand = "SELECT * FROM tblHistory";
        if (sortCriteria != null && !sortCriteria.isEmpty()) {
            sqlCommand += " ORDER BY ";
            switch (sortCriteria) {
                case "id":
                    sqlCommand += "Id";
                    break;
                case "dateinoldtonew":
                    sqlCommand += "DateIn ASC";
                    break;
                case "dateinnewtoold":
                    sqlCommand += "DateIn DESC";
                    break;
                case "dateoutoldtonew":
                    sqlCommand += "DateOut ASC";
                    break;
                case "dateoutnewtoold":
                    sqlCommand += "DateOut DESC";
                    break;
                case "pricelowtohigh":
                    sqlCommand += "TotalMoney ASC";
                    break;
                case "pricehightolow":
                    sqlCommand += "TotalMoney DESC";
                    break;
                default:
                    break;
            }
        }
        sqlCommand += " OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setInt(1, (offset-1)*10);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    History history = new History();
                    history.setId(rs.getInt("Id"));
                    history.setRoomNum(rs.getString("RoomNum"));
                    history.setNumberCus(rs.getInt("NumberUser"));
                    history.setDateIn(rs.getDate("DateIn"));
                    history.setDateOut(rs.getDate("DateOut"));
                    history.setTotalMoney(rs.getFloat("TotalMoney"));
                    historyList.add(history);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historyList;
    }

    public int countHistory() {
        int count = 0;
        String sqlCommand = "SELECT COUNT(*) AS count FROM tblHistory";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand); ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

}
