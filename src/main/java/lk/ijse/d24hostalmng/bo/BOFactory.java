package lk.ijse.d24hostalmng.bo;

import lk.ijse.d24hostalmng.bo.custom.impl.StudentBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){}

    public enum BOType{
        STUDENT,ROOM,RESERVATION
    }

    public static BOFactory getInstance(){
        return boFactory == null ? new BOFactory() : boFactory;
    }

    public <T extends SuperBO>T getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            default:
                return null;
        }
    }
}
