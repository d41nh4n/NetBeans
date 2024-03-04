package dal;

import Interface.DAOInterface;
import java.util.ArrayList;
import model.Login;

/**
 *
 * @author Dai Nhan
 */
public class LoginDao implements DAOInterface<Login> {

    private ArrayList<Login> logins = new ArrayList<>();

    public LoginDao() {
    }

    @Override
    public ArrayList<Login> getAll() {
        return logins;
    }

    @Override
    public Login getById(String id) {
        // Tìm kiếm login theo id
        for (Login login : logins) {
            if (login.getId().equals(id)) {
                return login; 
            }
        }
        return null; 
    }

    public int insertAll(ArrayList<Login> newLogins) {
        logins.addAll(newLogins);
        return newLogins.size(); 
    }

    @Override
    public int insert(Login newLogin) {
        logins.add(newLogin);
        return 1;
    }

    public int deleteAll(ArrayList<Login> deleteLogins) {
        logins.removeAll(deleteLogins);
        return deleteLogins.size(); 
    }

    @Override
    public int delete(Login deleteLogin) {
        logins.remove(deleteLogin);
        return 1;
    }

    @Override
    public int update(Login updatedLogin) {
        for (int i = 0; i < logins.size(); i++) {
            Login existingLogin = logins.get(i);
            if (existingLogin.getId().equals(updatedLogin.getId())) {
                logins.set(i, updatedLogin);
                return 1; 
            }
        }
        return 0; 
    }
}
