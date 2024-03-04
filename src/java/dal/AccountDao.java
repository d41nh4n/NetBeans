package dal;

import Interface.DAOInterface;
import DBConnection.DBContext;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author Dai Nhan
 */
public class AccountDao extends DBContext implements DAOInterface<Account> {
    
    private ArrayList<Account> accounts = new ArrayList<>();

    public AccountDao() {
    }

    @Override
    public ArrayList<Account> getAll() {
        return accounts;
    }

    @Override
    public Account getById(String id) {
        for (Account account : accounts) {
            if (account.getUserName().equals(id)) {
                return account; 
            }
        }
        return null; 
    }

    public int insertAll(ArrayList<Account> newAccounts) {
        accounts.addAll(newAccounts);
        return newAccounts.size(); 
    }

    @Override
    public int insert(Account newAccount) {
        accounts.add(newAccount);
        return 1;
    }

    public int deleteAll(ArrayList<Account> deleteAccounts) {
        accounts.removeAll(deleteAccounts);
        return deleteAccounts.size(); 
    }

    @Override
    public int delete(Account deleteAccount) {
        accounts.remove(deleteAccount);
        return 1; 
    }

    @Override
    public int update(Account updatedAccount) {
        for (int i = 0; i < accounts.size(); i++) {
            Account existingAccount = accounts.get(i);
            if (existingAccount.getUserName().equals(updatedAccount.getUserName())) {
                accounts.set(i, updatedAccount);
                return 1; 
            }
        }
        return 0;
    }
}
