/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.BookingDao;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Dai Nhan
 */

public class Booking implements Serializable {

    private String id;
    private String customerName;
    private String roomNumber;
    private Date dateIn;
    private Date dateOut;
    private Date execDate;
    private Float deposite;
    private String contact;
    
    public Booking() {
    }

    public Booking(String id, String customerName, String roomNumber, Date dateIn, Date dateOut, Date execDate, Float deposite, String contact) {
        this.id = id;
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.execDate = execDate;
        this.deposite = deposite;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
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

    public Date getExecDate() {
        return execDate;
    }

    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }

    public Float getDeposite() {
        return deposite;
    }

    public void setDeposite(Float deposite) {
        this.deposite = deposite;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", customerName=" + customerName + ", roomNumber=" + roomNumber + ", dateIn=" + dateIn + ", dateOut=" + dateOut + ", execDate=" + execDate + ", deposite=" + deposite + ", contact=" + contact + '}';
    }
    

    public List<Booking> getAllBookings() {
        return new BookingDao().getAll();
    }
    
    public Booking getById(String id) {
        return new BookingDao().getById(id);
    }

    public int insert(Booking booking) {
        return new BookingDao().insert(booking);
    }

    public int delete(Booking booking) {
        return new BookingDao().delete(booking);
    }

    public int update(Booking booking) {
        return new BookingDao().update(booking);
    }
    
    
}
