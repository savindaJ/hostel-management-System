package lk.ijse.d24hostalmng.dao;

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
            default:
                return null;
        }
    }
}
