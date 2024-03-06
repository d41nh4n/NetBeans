package dal;


import DBConnection.DBContext;
import Interface.DAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerDao extends DBContext implements DAOInterface<Customer> {

    @Override
    public ArrayList<Customer> getAll() {
        ArrayList<Customer> list = new ArrayList<>();
        String sqlCommand = "select * from tblCustomer";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Customer cus = new Customer(
                        rs.getString("FullName"),
                        rs.getDate("DOB"),
                        rs.getBoolean("Gender"),
                        rs.getString("Phone"),
                        rs.getString("Id"),
                        rs.getString("Nationality"));
                list.add(cus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Customer getById(String id) {
        String sqlCommand = "select * from tblCustomer where Id = ?";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setString(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new Customer(
                            rs.getString("FullName"),
                            rs.getDate("DOB"),
                            rs.getBoolean("Gender"),
                            rs.getString("Phone"),
                            rs.getString("Id"),
                            rs.getString("Nationality"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(Customer customer) {
        String sqlCommand = "insert into tblCustomer values (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setString(1, customer.getId());
            st.setString(2, customer.getFullName());
            st.setDate(3, new java.sql.Date(customer.getDob().getTime()));
            st.setBoolean(4, customer.isSex());
            st.setString(5, customer.getPhone());
            st.setString(6, customer.getNationality());
            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Customer customer) {
        String sqlCommand = "delete from tblCustomer where Id = ?";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setString(1, customer.getId());
            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Customer customer) {
        String sqlCommand = "update tblCustomer set FullName = ?, DOB = ?, Gender = ?, Phone = ?, Nationality = ? where Id = ?";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setString(1, customer.getFullName());
            st.setDate(2, new java.sql.Date(customer.getDob().getTime()));
            st.setBoolean(3, customer.isSex());
            st.setString(4, customer.getPhone());
            st.setString(5, customer.getNationality());
            st.setString(6, customer.getId());
            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<String> getListId() {
        List<String> list = new ArrayList<>();
        String sqlCommand = "select Id from tblCustomer";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                list.add(rs.getString("Id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalCustomer() {
        int count = 0;
        String sqlCommand = "SELECT COUNT(*) AS count FROM tblCustomer";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand); ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
        public ArrayList<Customer> searchListById(String idPattern) {
        ArrayList<Customer> list = new ArrayList<>();
        String sqlCommand = "SELECT * FROM tblCustomer WHERE id LIKE ?";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setString(1, "%" + idPattern + "%");
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Customer cus = new Customer(
                            rs.getString("FullName"),
                            rs.getDate("DOB"),
                            rs.getBoolean("Gender"),
                            rs.getString("Phone"),
                            rs.getString("Id"),
                            rs.getString("Nationality"));
                    list.add(cus);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new CustomerDao().getListId());
    }
}
