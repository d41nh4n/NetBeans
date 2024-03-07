/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.HistoryDao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dai Nhan
 */
public class History {

    private int id;
    private String roomNum;
    private int numberCus;
    private Date dateIn;
    private Date dateOut;
    private float totalMoney;

    public History() {
    }

    public History(int id, String roomNum, int numberCus, Date dateIn, Date dateOut, float totalMoney) {
        this.id = id;
        this.roomNum = roomNum;
        this.numberCus = numberCus;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.totalMoney = totalMoney;
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

    public int getNumberCus() {
        return numberCus;
    }

    public void setNumberCus(int numberCus) {
        this.numberCus = numberCus;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "History{" + "id=" + id + ", roomNum=" + roomNum + ", numberCus=" + numberCus + ", dateIn=" + dateIn + ", dateOut=" + dateOut + ", totalMoney=" + totalMoney + ", historyNumUser=" + '}';
    }

    public boolean create(History history) {
        return new HistoryDao().createHistory(history);
    }

    public boolean update(History history) {
        return new HistoryDao().updateHistory(history);
    }

    public boolean delete(History history) {
        return new HistoryDao().deleteHistory(history.getId());
    }

    public List<History> getAll() {
        return new HistoryDao().getAllHistory();
    }

    public History getById(History history) {
        return new HistoryDao().getById(history.getId());
    }

    public List<History> getByPage(int index, String choice) {
        return new HistoryDao().getByPage(index,choice);
    }

    public int count() {
        return new HistoryDao().countHistory();
    }
}
