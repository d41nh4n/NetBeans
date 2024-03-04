/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Interface.DAOInterface;
import java.util.ArrayList;
import model.Employee;

/**
 *
 * @author Dai Nhan
 */
public class EmployeeDao implements DAOInterface<Employee> {

    private ArrayList<Employee> listEmployee = new ArrayList<>();

    public EmployeeDao() {
    }
    

    @Override
    public ArrayList<Employee> getAll() {
        return listEmployee;
    }

    @Override
    public Employee getById(String id) {
        if (listEmployee.isEmpty() || listEmployee == null) {
            return null;
        }

        for (Employee e : listEmployee) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public int insertAll(ArrayList<Employee> o) {
        int count = 0;
        for (Employee e : o) {
            count += insert(e);
        }
        return count;
    }

    @Override
    public int insert(Employee o) {
        if (getById(o.getId()) == null) {
            listEmployee.add(o);
            return 1;
        }
        return 0;
    }

    public int deleteAll(ArrayList<Employee> o) {
        if (listEmployee.isEmpty() || listEmployee == null) {
            return 0;
        }

        int count = 0;

        for (Employee e : o) {
            count += delete(e);
        }
        return count;
    }

    @Override
    public int delete(Employee o) {
        if (listEmployee.isEmpty() || listEmployee == null) {
            return 0;
        }

        if (getById(o.getId()) != null) {
            listEmployee.remove(o);
            return 1;
        }
        return 0;
    }

    @Override
    public int update(Employee o) {

        if (listEmployee.isEmpty() || listEmployee == null) {
            return 0;
        }
        for (Employee e : listEmployee) {
            if (o.getId().equals(e.getId())) {
                e.setFullName(o.getFullName());
                e.setDob(o.getDob());
                e.setSex(o.isSex());
                e.setPhone(o.getPhone());
                e.setUserName(o.getUserName());
                return 1;
            }
        }
        return 0;
    }
}
