/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Interface.Person;
import dal.CustomerDao;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Dai Nhan
 */
public class Customer extends Person implements Serializable {

    private String nationality;

    public Customer() {

    }

    public Customer(String fullName, Date dob, boolean sex, String phone, String id, String nationality) {
        super(fullName, dob, sex, phone, id);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Customer> getAll() {
        return new CustomerDao().getAll();
    }

    public Customer getById(String id) {
        return new CustomerDao().getById(id);
    }

    public int insert(Customer o) {
        return new CustomerDao().insert(o);
    }

    public int delete(Customer o) {
        return new CustomerDao().delete(o);
    }

    public int update(Customer o) {
        return new CustomerDao().update(o);
    }

    public List<Customer> getListById(String id) {
        return new CustomerDao().searchListById(id);
    }
}
