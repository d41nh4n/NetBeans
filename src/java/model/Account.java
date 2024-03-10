/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.AccountDao;
import java.util.List;

/**
 *
 * @author Dai Nhan
 */
public class Account {

    private String userName;
    private String passWord;
    private int role;
    private boolean status;
    private String email;

    public Account() {
    }

    public Account(String userName, String passWord, int role, String email, boolean status) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
        this.status = status;
        this.email = email;
    }

    public Account(String userName, String passWord, int role, String email) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
        this.status = false;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" + "userName=" + userName + ", passWord=" + passWord + ", role=" + role + ", status=" + status + ", email=" + email + '}';
    }
    

    public List<Account> getAll() {
        return new AccountDao().getAll();
    }

    public Account getById(String id) {
        return new AccountDao().getById(id);
    }

    public int insert(Account o) {
        return new AccountDao().insert(o);
    }

    public int delete(Account o) {
        return new AccountDao().delete(o);
    }

    public int update(Account o) {
        return new AccountDao().update(o);
    }

    public Account getByEmail(String email) {
        return new AccountDao().getByEmail(email);
    }

    public Account getByLogin(String user, String pass) {
        return new AccountDao().getByLogin(user, pass);
    }
}
