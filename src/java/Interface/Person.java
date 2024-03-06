/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Dai Nhan
 */
public abstract class Person implements Serializable {

    private String fullName;
    private Date dob;
    private boolean sex;
    private String phone;
    private String id;

    public Person() {
    }
    
    protected Person(String fullName, Date dob, boolean sex, String phone, String id) {
        this.fullName = fullName;
        this.dob = dob;
        this.sex = sex;
        this.phone = phone;
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" + "fullName=" + fullName + ", dob=" + dob + ", sex=" + sex + ", phone=" + phone + ", id=" + id + '}';
    }
    
}
