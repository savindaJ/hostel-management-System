package lk.ijse.d24hostalmng.dao;

import org.hibernate.Session;

import java.util.List;

public interface CrudDAO <T,J> extends SuperDAO{

    boolean save(T t);

    boolean update(T t);

    boolean delete(J j);

    T find(J j);

    List<T> getAll();

    void setSession(Session session);
}
