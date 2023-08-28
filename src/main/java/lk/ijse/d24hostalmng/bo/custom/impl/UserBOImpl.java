package lk.ijse.d24hostalmng.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.d24hostalmng.bo.custom.UserBO;
import lk.ijse.d24hostalmng.configuration.Configure;
import lk.ijse.d24hostalmng.dao.DAOFactory;
import lk.ijse.d24hostalmng.dao.custom.UserDAO;
import lk.ijse.d24hostalmng.dto.UserDTO;
import lk.ijse.d24hostalmng.entity.User;
import org.hibernate.Session;

import java.util.List;

public class UserBOImpl implements UserBO {

    private final UserDAO userDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.USERDAO);

    @Override
    public boolean save(UserDTO userDTO) {
        Session session = Configure.getInstance().getSession();
        userDAO.setSession(session);
        return userDAO.save(new User(
                userDTO.getGmail(),
                userDTO.getPassword()
        ));
    }

    @Override
    public boolean update(UserDTO userDTO) {
        Session session = Configure.getInstance().getSession();
        userDAO.setSession(session);
        return userDAO.update(new User(
                userDTO.getGmail(),
                userDTO.getPassword()
        ));
    }

    @Override
    public boolean delete(String s) {
        Session session = Configure.getInstance().getSession();
        userDAO.setSession(session);
        return userDAO.delete(s);
    }

    @Override
    public UserDTO find(String s) {
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public UserDTO findCredential(String text) {
        Session session = Configure.getInstance().getSession();
        userDAO.setSession(session);
        User user = userDAO.find(text);
        if (user!=null){
            return new UserDTO(
                    user.getGmail(),
                    user.getPassword()
            );
        }else {
            return null;
        }

    }
}
