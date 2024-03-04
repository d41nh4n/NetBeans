/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Dai Nhan
 */
public class HistoryNumberUser {

    private ArrayList<Customer> idCustomer;
    private String idHistory;

    public HistoryNumberUser() {
    }

    public HistoryNumberUser(ArrayList<Customer> idCustomer, String idHistory) {
        this.idCustomer = idCustomer;
        this.idHistory = idHistory;
    }

    public ArrayList<Customer> getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(ArrayList<Customer> idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(String idHistory) {
        this.idHistory = idHistory;
    }
}
