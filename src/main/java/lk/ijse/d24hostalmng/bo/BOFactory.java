package lk.ijse.d24hostalmng.bo;

import lk.ijse.d24hostalmng.bo.custom.impl.ReservationBOImpl;
import lk.ijse.d24hostalmng.bo.custom.impl.RoomBoImpl;
import lk.ijse.d24hostalmng.bo.custom.impl.StudentBOImpl;
import lk.ijse.d24hostalmng.bo.custom.impl.UserBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){}

    public enum BOType{
        STUDENT,ROOM,RESERVATION,USER
    }

    public static BOFactory getInstance(){
        return boFactory == null ? new BOFactory() : boFactory;
    }

    public <T extends SuperBO>T getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            case ROOM:
                return (T) new RoomBoImpl();
            case RESERVATION:
                return (T) new ReservationBOImpl();
            case USER:
                return (T) new UserBOImpl();
            default:
                return null;
        }
    }
}
