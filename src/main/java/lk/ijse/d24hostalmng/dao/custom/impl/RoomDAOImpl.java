package lk.ijse.d24hostalmng.dao.custom.impl;

import lk.ijse.d24hostalmng.dao.custom.RoomDAO;
import lk.ijse.d24hostalmng.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Student student) {
        return false;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Student find(String s) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }
}
