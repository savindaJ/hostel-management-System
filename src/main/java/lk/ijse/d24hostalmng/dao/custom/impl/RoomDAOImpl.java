package lk.ijse.d24hostalmng.dao.custom.impl;

import lk.ijse.d24hostalmng.dao.custom.RoomDAO;
import lk.ijse.d24hostalmng.entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
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
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Room find(String s) {
        return null;
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
        String newId = "RM001";
        Transaction transaction = session.beginTransaction();
        List list = session.createNativeQuery("select room_id from room order by room_id desc limit 1").list();
        if (!list.isEmpty()) newId = (String) list.get(0);
        transaction.commit();
        session.close();
        return newId;
    }
}
