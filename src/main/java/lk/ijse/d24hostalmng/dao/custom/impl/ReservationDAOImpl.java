package lk.ijse.d24hostalmng.dao.custom.impl;

import lk.ijse.d24hostalmng.dao.custom.ReservationDAO;
import lk.ijse.d24hostalmng.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    private Session session;

    @Override
    public boolean save(Reservation reservation) {
        return false;
    }

    @Override
    public boolean update(Reservation reservation) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Reservation find(String s) {
        return null;
    }

    @Override
    public List<Reservation> getAll() {
        return null;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public String getNextId() {
        String newId = "RES000";
        Transaction transaction = session.beginTransaction();
        List list = session.createNativeQuery("select reservation_id from reservation order by reservation_id desc limit 1").list();
        if (!list.isEmpty()) newId = (String) list.get(0);
        transaction.commit();
        session.close();
        return newId;
    }
}
