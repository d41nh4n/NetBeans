/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import DBConnection.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import model.HistoryReceiveMoney;

/**
 *
 * @author Dai Nhan
 */
public class HistoryRMDao extends DBContext {

    public boolean createHistoryReceiveMoney(HistoryReceiveMoney historyReceiveMoney) {
        String query = "INSERT INTO tblHistoryReceiveMoney (RoomNum, DatePay, Money, Status,UserName) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, historyReceiveMoney.getRoomNum());
            ps.setDate(2, historyReceiveMoney.getDatePay());
            ps.setFloat(3, historyReceiveMoney.getMoney());
            ps.setString(4, historyReceiveMoney.getStatus());
            ps.setString(5, historyReceiveMoney.getUserName());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<HistoryReceiveMoney> getAllHistoryReceiveMoney() {
        List<HistoryReceiveMoney> historyReceiveMoneyList = new ArrayList<>();
        String query = "SELECT * FROM tblHistoryReceiveMoney";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HistoryReceiveMoney historyReceiveMoney = new HistoryReceiveMoney();
                historyReceiveMoney.setId(rs.getInt("Id"));
                historyReceiveMoney.setRoomNum(rs.getString("RoomNum"));
                historyReceiveMoney.setDatePay(rs.getDate("DatePay"));
                historyReceiveMoney.setMoney(rs.getFloat("Money"));
                historyReceiveMoney.setStatus(rs.getString("Status"));
                historyReceiveMoney.setUserName(rs.getString("UserName"));
                historyReceiveMoneyList.add(historyReceiveMoney);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historyReceiveMoneyList;
    }

    public boolean updateHistoryReceiveMoney(HistoryReceiveMoney historyReceiveMoney) {
        String query = "UPDATE tblHistoryReceiveMoney SET RoomNum=?, DatePay=?, Money=?, Status=?, UserName=? WHERE Id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, historyReceiveMoney.getRoomNum());
            ps.setDate(2, historyReceiveMoney.getDatePay());
            ps.setFloat(3, historyReceiveMoney.getMoney());
            ps.setString(4, historyReceiveMoney.getStatus());
            ps.setString(5, historyReceiveMoney.getUserName());
            ps.setInt(6, historyReceiveMoney.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteHistoryReceiveMoney(int id) {
        String query = "DELETE FROM tblHistoryReceiveMoney WHERE Id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<HistoryReceiveMoney> getHistoryReceiveMoneyByPage(int offset, String sortCriteria) {
        List<HistoryReceiveMoney> historyReceiveMoneyList = new ArrayList<>();
        String sqlCommand = "SELECT * FROM tblHistoryReceiveMoney";
        if (sortCriteria != null && !sortCriteria.isEmpty()) {
            sqlCommand += " ORDER BY ";
            switch (sortCriteria) {
                case "id":
                    sqlCommand += "Id";
                    break;
                case "datepaynewtoold":
                    sqlCommand += "DatePay DESC";
                    break;
                case "datepayoldtonew":
                    sqlCommand += "DatePay ASC";
                    break;
                case "moneylowtohigh":
                    sqlCommand += "Money ASC";
                    break;
                case "moneyhightolow":
                    sqlCommand += "Money DESC";
                    break;
                case "sortbyroomfromlowtohigh":
                    sqlCommand += "RoomNum ASC";
                    break;
                case "sortbyroomfromhightolow":
                    sqlCommand += "RoomNum DESC";
                    break;
                default:
                    break;
            }
        }
        sqlCommand += " OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setInt(1, (offset - 1) * 10);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    HistoryReceiveMoney historyReceiveMoney = new HistoryReceiveMoney();
                    historyReceiveMoney.setId(rs.getInt("Id"));
                    historyReceiveMoney.setRoomNum(rs.getString("RoomNum"));
                    historyReceiveMoney.setDatePay(rs.getDate("DatePay"));
                    historyReceiveMoney.setMoney(rs.getFloat("Money"));
                    historyReceiveMoney.setStatus(rs.getString("Status"));
                    historyReceiveMoney.setUserName(rs.getString("UserName"));
                    historyReceiveMoneyList.add(historyReceiveMoney);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historyReceiveMoneyList;
    }

    public int countHistoryReceiveMoney() {
        int count = 0;
        String sqlCommand = "SELECT COUNT(*) AS count FROM tblHistoryReceiveMoney";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand); ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<HistoryReceiveMoney> getHistoryReceiveMoneyByRoom(String room, Date dateIn, Date dateOut) {
        List<HistoryReceiveMoney> historyReceiveMoneyList = new ArrayList<>();
        String query = "SELECT * FROM tblHistoryReceiveMoney where RoomNum = ? and DatePay >= ? and DatePay < ? ";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, room);
            ps.setDate(2, dateIn);
            ps.setDate(3, dateOut);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HistoryReceiveMoney historyReceiveMoney = new HistoryReceiveMoney();
                historyReceiveMoney.setId(rs.getInt("Id"));
                historyReceiveMoney.setRoomNum(rs.getString("RoomNum"));
                historyReceiveMoney.setDatePay(rs.getDate("DatePay"));
                historyReceiveMoney.setMoney(rs.getFloat("Money"));
                  historyReceiveMoney.setStatus(rs.getString("Status"));
                historyReceiveMoney.setUserName(rs.getString("UserName"));
                historyReceiveMoneyList.add(historyReceiveMoney);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historyReceiveMoneyList;
    }
}
