/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Dai Nhan
 */
public class History {
    private String id;
    private String roomNum;
    private int numberCus;
    private Date dateIn;
    private Date dateOut;
    private float totalMoney;
    
    private HistoryNumberUser historyNumUser;
    public History() {
    }

    public History(String id, String roomNum, int numberCus, Date dateIn, Date dateOut, float totalMoney, HistoryNumberUser historyNumUser) {
        this.id = id;
        this.roomNum = roomNum;
        this.numberCus = numberCus;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.totalMoney = totalMoney;
        this.historyNumUser = historyNumUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public HistoryNumberUser getHistoryNumUser() {
        return historyNumUser;
    }

    public void setHistoryNumUser(HistoryNumberUser historyNumUser) {
        this.historyNumUser = historyNumUser;
    }
    
    
}