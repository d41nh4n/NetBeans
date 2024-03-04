/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Interface.Person;
import java.io.Serializable;
import java.sql.Date;


/**
 *
 * @author Dai Nhan
 */
public class Employee extends Person implements Serializable{
    
        private String userName;
        
     public Employee(){
     }
        
    public Employee(String fullName, Date dob, boolean sex, String phone, String id,  String userName) {
        super(fullName, dob, sex, phone, id);
        this.userName = userName;
    }    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
