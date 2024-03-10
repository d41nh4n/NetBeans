package dal;

import DBConnection.DBContext;
import Interface.DAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;

public class EmployeeDAO extends DBContext implements DAOInterface<Employee> {

    public EmployeeDAO() {
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> listEmployees = new ArrayList<>();
        String sqlCommand = "SELECT * FROM tblEmployee";
        try {
            PreparedStatement st = connection.prepareStatement(sqlCommand);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getString("FullName"),
                        rs.getDate("DOB"),
                        rs.getBoolean("Gender"),
                        rs.getString("Phone"),
                        rs.getString("Id"),
                        rs.getString("Username")
                );
                listEmployees.add(employee);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            close();
        }
        return listEmployees;
    }

    @Override
    public Employee getById(String id) {
        String sqlCommand = "SELECT * FROM tblEmployee WHERE Id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sqlCommand);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee(
                        rs.getString("FullName"),
                        rs.getDate("DOB"),
                        rs.getBoolean("Gender"),
                        rs.getString("Phone"),
                        rs.getString("Id"),
                        rs.getString("Username")
                );
                return employee;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            close();
        }
        return null;
    }

    @Override
    public int insert(Employee employee) {
        String sqlCommand = "INSERT INTO tblEmployee (FullName, DOB, Gender, Phone, Id, Username)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setString(1, employee.getFullName());
            st.setDate(2, employee.getDob());
            st.setBoolean(3, employee.isSex());
            st.setString(4, employee.getPhone());
            st.setString(5, employee.getId());
            st.setString(6, employee.getUserName());
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0 ? 1 : 0;
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Error inserting employee", e);
        }
        return 0;
    }

    @Override
    public int update(Employee employee) {
        int rowsAffected = 0;
        String updateCommand = "UPDATE tblEmployee SET "
                + "FullName = ?, "
                + "DOB = ?, "
                + "Gender = ?, "
                + "Phone = ?, "
                + "Username = ? "
                + "WHERE Id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(updateCommand);
            st.setString(1, employee.getFullName());
            st.setDate(2, employee.getDob());
            st.setBoolean(3, employee.isSex());
            st.setString(4, employee.getPhone());
            st.setString(5, employee.getUserName());
            st.setString(6, employee.getId());
            rowsAffected = st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowsAffected;
    }

    @Override
    public int delete(Employee employee) {
        String sqlCommand = "DELETE FROM tblEmployee WHERE Id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlCommand)) {
            statement.setString(1, employee.getId());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0 ? 1 : 0;
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
}
