package lk.ijse.d24hostalmng.dao.custom.impl;

import lk.ijse.d24hostalmng.dao.custom.QuaryDAO;
import lk.ijse.d24hostalmng.dto.CustomReservationDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuaryDAOImpl implements QuaryDAO {

    private Session session;

    @Override
    public List<CustomReservationDTO> getAllReservation() {
        List<CustomReservationDTO> dtos = new ArrayList<>();
        Transaction transaction = session.beginTransaction();
        List<Object[]> list = session.createNativeQuery("select r.reservation_id,r.student_id,s.student_name,R.room_id,room.room_type,r.reservation_date,room.key_money,r.reservation_status,r.key_money_exp_date from reservation r join student s join room  ON r.student_id = s.student_id && r.room_id = room.room_id").list();

        transaction.commit();
        session.close();
        if (list.isEmpty()){
            System.out.println("empty");
        }else {
            for (Object[] objects : list){
                dtos.add(new CustomReservationDTO(
                        (String) objects[0],
                        (String) objects[1],
                        (String) objects[2],
                        (String) objects[3],
                        (String) objects[4],
                        (Date) objects[5],
                        (Double) objects[6],
                        (String) objects[7],
                        (Date) objects[8]
                ));
            }
        }

        return dtos;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public List<CustomReservationDTO> getTypeOfList(String value) {
        return getViewTypeList(value);
    }

    private List<CustomReservationDTO> getViewTypeList(String type) {
        List<CustomReservationDTO> dtos = new ArrayList<>();
        Transaction transaction = session.beginTransaction();
        List<Object[]> list=null;
        switch (type){
            case "PENDING":
                list = session.createNativeQuery("select r.reservation_id,r.student_id,s.student_name,R.room_id,room.room_type,r.reservation_date,room.key_money,r.reservation_status,r.key_money_exp_date from reservation r join student s join room  ON r.student_id = s.student_id && r.room_id = room.room_id where r.reservation_status='PENDING'").list();
                break;
            case "PAID":
                list = session.createNativeQuery("select r.reservation_id,r.student_id,s.student_name,R.room_id,room.room_type,r.reservation_date,room.key_money,r.reservation_status,r.key_money_exp_date from reservation r join student s join room  ON r.student_id = s.student_id && r.room_id = room.room_id where r.reservation_status='PAID'").list();
                break;
            case "EXPIRED":
                list = session.createNativeQuery("select r.reservation_id,r.student_id,s.student_name,R.room_id,room.room_type,r.reservation_date,room.key_money,r.reservation_status,r.key_money_exp_date from reservation r join student s join room  ON r.student_id = s.student_id && r.room_id = room.room_id where r.reservation_status='EXPIRED'").list();
                break;
            default:
                list = session.createNativeQuery("select r.reservation_id,r.student_id,s.student_name,R.room_id,room.room_type,r.reservation_date,room.key_money,r.reservation_status,r.key_money_exp_date from reservation r join student s join room  ON r.student_id = s.student_id && r.room_id = room.room_id").list();
        }

        transaction.commit();
        session.close();
        if (list.isEmpty()){
            System.out.println("empty");
        }else {
            for (Object[] objects : list){
                dtos.add(new CustomReservationDTO(
                        (String) objects[0],
                        (String) objects[1],
                        (String) objects[2],
                        (String) objects[3],
                        (String) objects[4],
                        (Date) objects[5],
                        (Double) objects[6],
                        (String) objects[7],
                        (Date) objects[8]
                ));
            }
        }

        return dtos;
    }
}
