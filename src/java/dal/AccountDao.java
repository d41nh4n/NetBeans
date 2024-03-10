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
import model.Account;

public class AccountDao extends DBContext implements DAOInterface<Account> {

    public AccountDao() {
    }

    @Override
    public List<Account> getAll() {
        List<Account> listAccounts = new ArrayList<>();
        String sqlCommand = "SELECT * FROM tblAccount";
        try {
            PreparedStatement st = connection.prepareStatement(sqlCommand);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account account = new Account(
                        rs.getString("UserName"),
                        rs.getString("PassWord"),
                        rs.getInt("Authority"),
                        rs.getString("Email"),
                        rs.getBoolean("Status")
                );
                listAccounts.add(account);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            close();
        }
        return listAccounts;
    }

    @Override
    public Account getById(String id) {
        String sqlCommand = "SELECT * FROM tblAccount WHERE UserName = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sqlCommand);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account account = new Account(
                        rs.getString("UserName"),
                        rs.getString("PassWord"),
                        rs.getInt("Authority"),
                        rs.getString("Email"),
                        rs.getBoolean("Status")
                );
                return account;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            close();
        }
        return null;
    }

    @Override
    public int insert(Account account) {
        String sqlCommand = "INSERT INTO tblAccount (UserName, PassWord, Authority, Status, Email)"
                + "VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement st = connection.prepareStatement(sqlCommand)) {
            st.setString(1, account.getUserName());
            st.setString(2, account.getPassWord());
            st.setInt(3, account.getRole());
            st.setBoolean(4, account.isStatus());
            st.setString(5, account.getEmail());
            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0 ? 1 : 0;
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Error inserting account", e);
        }
        return 0;
    }

    @Override
    public int update(Account account) {
        int rowsAffected = 0;
        String updateCommand = "UPDATE tblAccount SET "
                + "PassWord = ?, "
                + "Authority = ?, "
                + "Status = ?, "
                + "Email = ? "
                + "WHERE UserName = ?";
        try {
            PreparedStatement st = connection.prepareStatement(updateCommand);
            st.setString(1, account.getPassWord());
            st.setInt(2, account.getRole());
            st.setBoolean(3, account.isStatus());
            st.setString(4, account.getEmail());
            st.setString(5, account.getUserName());
            rowsAffected = st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return rowsAffected;
    }

    @Override
    public int delete(Account account) {
        String sqlCommand = "DELETE FROM tblAccount WHERE UserName = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlCommand)) {
            statement.setString(1, account.getUserName());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0 ? 1 : 0;
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public Account getByEmail(String email) {
        String sqlCommand = "SELECT * FROM tblAccount WHERE Email = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sqlCommand);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account account = new Account(
                        rs.getString("UserName"),
                        rs.getString("PassWord"),
                        rs.getInt("Authority"),
                        rs.getString("Email"),
                        rs.getBoolean("Status")
                );
                return account;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            close();
        }
        return null;
    }

    public Account getByLogin(String userName, String password) {
        String sqlCommand = "SELECT * FROM tblAccount WHERE UserName = ? AND PassWord = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sqlCommand);
            st.setString(1, userName);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account account = new Account(
                        rs.getString("UserName"),
                        rs.getString("PassWord"),
                        rs.getInt("Authority"),
                        rs.getString("Email"),
                        rs.getBoolean("Status")
                );
                return account;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            close();
        }
        return null;
    }

    public static void main(String[] args) {
        AccountDao ac = new AccountDao();
        ac.insert(new Account("admin1", "admin", 1, "nhan@gmail.com"));
    }
}
