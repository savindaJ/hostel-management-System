package lk.ijse.d24hostalmng.dao;

import lk.ijse.d24hostalmng.bo.custom.impl.RoomBoImpl;
import lk.ijse.d24hostalmng.dao.custom.impl.RoomDAOImpl;
import lk.ijse.d24hostalmng.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public enum DAOType{
        STUDENTDAO,ROOMDAO,RESERVATIONDAO,RESERVATIONDETAILDAO
    }

    public static DAOFactory getInstance(){
        return daoFactory == null ? new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO>T getDAO(DAOType daoType){
        switch (daoType){
            case STUDENTDAO:
                return (T) new StudentDAOImpl();
            case ROOMDAO:
                return (T) new RoomDAOImpl();
            default:
                return null;
        }
    }
}
