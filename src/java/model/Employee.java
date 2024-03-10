/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Interface.Person;
import dal.EmployeeDAO;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Dai Nhan
 */
public class Employee extends Person implements Serializable {

    private String userName;

    public Employee() {
    }

    public Employee(String fullName, Date dob, boolean sex, String phone, String id, String userName) {
        super(fullName, dob, sex, phone, id);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Employee> getAll() {
        return new EmployeeDAO().getAll();
    }

    public Employee getById(String id) {
        return new EmployeeDAO().getById(id);
    }

    public int insert(Employee employee) {
        return new EmployeeDAO().insert(employee);
    }

    public int update(Employee employee) {
        return new EmployeeDAO().update(employee);
    }

    public int delete(Employee employee) {
        return new EmployeeDAO().delete(employee);
    }
}
