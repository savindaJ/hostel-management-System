package lk.ijse.d24hostalmng.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.d24hostalmng.dao.custom.UserDAO;
import lk.ijse.d24hostalmng.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private Session session;

    @Override
    public boolean save(User user) {
        try {
            Transaction transaction = session.beginTransaction();
            Serializable save = session.save(user);
            transaction.commit();
            return save!=null;
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(User user) {
       try {
           Transaction transaction = session.beginTransaction();
           session.update(user);
           transaction.commit();
           return true;
       }catch (Exception e){
           new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
           return false;
       }finally {
           session.close();
       }
    }

    @Override
    public boolean delete(String s) {
        try {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, s);
            session.delete(user);
            transaction.commit();
            return true;
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public User find(String s) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void setSession(Session session) {
        this.session =  session;
    }
}
