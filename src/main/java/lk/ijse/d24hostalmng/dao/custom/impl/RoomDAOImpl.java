package lk.ijse.d24hostalmng.dao.custom.impl;

import lk.ijse.d24hostalmng.dao.custom.RoomDAO;
import lk.ijse.d24hostalmng.entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    private Session session;

    @Override
    public boolean save(Room room) {
       try {
           Transaction transaction = session.beginTransaction();
           Serializable save = session.save(room);
           transaction.commit();
           return save != null;
       }catch (Exception e){
           return false;
       }finally {
           session.close();
       }
    }

    @Override
    public boolean update(Room room) {
        try {
            Transaction transaction = session.beginTransaction();
            session.update(room);
            transaction.commit();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String s) {
        try {
            Transaction transaction = session.beginTransaction();
            Room room = session.get(Room.class, s);
            session.delete(room);
            transaction.commit();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public Room find(String s) {
        try {
            Transaction transaction = session.beginTransaction();
            Room room = session.get(Room.class, s);
            transaction.commit();
            return room;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public List<Room> getAll() {
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Room> query = criteriaBuilder.createQuery(Room.class);
        query.from(Room.class);
        List<Room> resultList = session.createQuery(query).getResultList();
        transaction.commit();
        session.close();
        return resultList;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public String getNextID() {
        String newId = "RM000";
        Transaction transaction = session.beginTransaction();
        List list = session.createNativeQuery("select room_id from room order by room_id desc limit 1").list();
        if (!list.isEmpty()) newId = (String) list.get(0);
        transaction.commit();
        session.close();
        return newId;
    }

    @Override
    public String getRoomTotalForTypes() {
        try {
            Transaction transaction = session.beginTransaction();
            List resultList = session.createNativeQuery("SELECT COUNT(*) from room").getResultList();
            BigInteger count = (BigInteger) resultList.get(0);
            transaction.commit();
            return String.valueOf(count);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public String getAvilbleRoomCount() {
        try {
            Transaction transaction = session.beginTransaction();
            List resultList = session.createNativeQuery("SELECT SUM(room_qty) from room").getResultList();
            BigDecimal count = (BigDecimal) resultList.get(0);
            transaction.commit();
            return String.valueOf(count);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
}
