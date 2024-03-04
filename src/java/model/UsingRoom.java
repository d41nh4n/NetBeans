/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import dal.UsingRoomDao;
import java.sql.Date;
import java.util.List;
/**
 *
 * @author Dai Nhan
 */
public class UsingRoom {
   
    private String roomNum;
    private int numberUser;
    private Date datein;
    private Date dateout;
    private float deposite;
    private float priceTotal;

    public UsingRoom() {
    }

    public UsingRoom(String roomNum, int numberUser, Date datein, Date dateout, float deposite, float priceTotal) {
        this.roomNum = roomNum;
        this.numberUser = numberUser;
        this.datein = datein;
        this.dateout = dateout;
        this.deposite = deposite;
        this.priceTotal = priceTotal;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public int getNumberUser() {
        return numberUser;
    }

    public void setNumberUser(int numberUser) {
        this.numberUser = numberUser;
    }

    public Date getDatein() {
        return datein;
    }

    public void setDatein(Date datein) {
        this.datein = datein;
    }

    public Date getDateout() {
        return dateout;
    }

    public void setDateout(Date dateout) {
        this.dateout = dateout;
    }

    public float getDeposite() {
        return deposite;
    }

    public void setDeposite(float deposite) {
        this.deposite = deposite;
    }

    public float getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(float priceTotal) {
        this.priceTotal = priceTotal;
    }
     
      public List<UsingRoom> getAll() {
        return new UsingRoomDao().getAll();
    }
    
    public UsingRoom getById(String id) {
        return new UsingRoomDao().getById(id);
    }

    public int insert(UsingRoom o) {
        return new UsingRoomDao().insert(o);
    }

    public int delete(UsingRoom o) {
        return new UsingRoomDao().delete(o);
    }

    public int update(UsingRoom o) {
        return new UsingRoomDao().update(o);
    }
}