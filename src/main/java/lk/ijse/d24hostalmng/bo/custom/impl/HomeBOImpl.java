package lk.ijse.d24hostalmng.bo.custom.impl;

import lk.ijse.d24hostalmng.bo.custom.HomeBO;
import lk.ijse.d24hostalmng.configuration.Configure;
import lk.ijse.d24hostalmng.dao.DAOFactory;
import lk.ijse.d24hostalmng.dao.custom.RoomDAO;
import lk.ijse.d24hostalmng.dao.custom.StudentDAO;
import org.hibernate.Session;

public class HomeBOImpl implements HomeBO {

    StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENTDAO);
    RoomDAO roomDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ROOMDAO);

    @Override
    public String getStuTotal() {
        Session session = Configure.getInstance().getSession();
        studentDAO.setSession(session);
        return studentDAO.getStuToatal();
    }

    @Override
    public String getRoomTotalForTypes() {
        Session session = Configure.getInstance().getSession();
        roomDAO.setSession(session);
        return roomDAO.getRoomTotalForTypes();
    }

    @Override
    public String getAvlTotal() {
        Session session = Configure.getInstance().getSession();
        roomDAO.setSession(session);
        return roomDAO.getAvilbleRoomCount();
    }
}
