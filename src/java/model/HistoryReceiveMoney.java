/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.HistoryRMDao;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Dai Nhan
 */
public class HistoryReceiveMoney {

    private int id;
    private String roomNum;
    private Date datePay;
    private float money;
    private String status;
    private String userName;

    public HistoryReceiveMoney() {
    }

    public HistoryReceiveMoney(int id, String roomNum, Date datePay, float money, String status, String userName) {
        this.id = id;
        this.roomNum = roomNum;
        this.datePay = datePay;
        this.money = money;
        this.status = status;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public Date getDatePay() {
        return datePay;
    }

    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "HistoryReceiveMoney{" + "id=" + id + ", roomNum=" + roomNum + ", datePay=" + datePay + ", money=" + money + ", status=" + status + ", userName=" + userName + '}';
    }

    public List<HistoryReceiveMoney> getAll() {
        return new HistoryRMDao().getAllHistoryReceiveMoney();
    }

    public boolean insert(HistoryReceiveMoney historyReceiveMoney) {
        return new HistoryRMDao().createHistoryReceiveMoney(historyReceiveMoney);
    }

    public boolean delete(HistoryReceiveMoney historyReceiveMoney) {
        return new HistoryRMDao().deleteHistoryReceiveMoney(historyReceiveMoney.getId());
    }

    public boolean update(HistoryReceiveMoney historyReceiveMoney) {
        return new HistoryRMDao().updateHistoryReceiveMoney(historyReceiveMoney);
    }

    public List<HistoryReceiveMoney> getByPage(int offset, String sort) {
        return new HistoryRMDao().getHistoryReceiveMoneyByPage(offset, sort);
    }

    public List<HistoryReceiveMoney> getByRoom(String room, Date dateIn, Date dateOut) {
        return new HistoryRMDao().getHistoryReceiveMoneyByRoom(room, dateIn, dateOut);
    }

    public int count() {
        return new HistoryRMDao().countHistoryReceiveMoney();
    }
}
