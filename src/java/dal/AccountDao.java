package dal;

import Interface.DAOInterface;
import DBConnection.DBContext;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author Dai Nhan
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends DBContext implements DAOInterface<Account> {

    @Override
    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = this.connection;
            String sql = "SELECT * FROM tblAccount";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("UserName");
                String password = resultSet.getString("PassWord");
                int authority = resultSet.getInt("Authority");
                boolean status = resultSet.getBoolean("Status");

                Account account = new Account(username, password, authority, status);
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return accounts;
    }

    @Override
    public Account getById(String id) {
        Account account = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
           connection = this.connection;
            String sql = "SELECT * FROM tblAccount WHERE UserName = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("UserName");
                String password = resultSet.getString("PassWord");
                int authority = resultSet.getInt("Authority");
                boolean status = resultSet.getBoolean("Status");

                account = new Account(username, password, authority, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return account;
    }

    @Override
    public int insert(Account o) {
        int rowsAffected = 0;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = this.connection;
            String sql = "INSERT INTO tblAccount (UserName, PassWord, Authority, Status) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, o.getUserName());
            statement.setString(2, o.getPassWord());
            statement.setInt(3, o.getRole());
            statement.setBoolean(4, o.isStatus());
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowsAffected;
    }

    @Override
    public int delete(Account o) {
        int rowsAffected = 0;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = this.connection;
            String sql = "DELETE FROM tblAccount WHERE UserName = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, o.getUserName());
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowsAffected;
    }

    @Override
    public int update(Account o) {
        int rowsAffected = 0;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = this.connection;
            String sql = "UPDATE tblAccount SET PassWord = ?, Authority = ?, Status = ? WHERE UserName = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, o.getPassWord());
            statement.setInt(2, o.getRole());
            statement.setBoolean(3, o.isStatus());
            statement.setString(4, o.getUserName());
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowsAffected;
    }
}
