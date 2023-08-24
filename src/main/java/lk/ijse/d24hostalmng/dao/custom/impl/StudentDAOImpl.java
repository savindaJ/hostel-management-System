package lk.ijse.d24hostalmng.dao.custom.impl;

import lk.ijse.d24hostalmng.dao.custom.StudentDAO;
import lk.ijse.d24hostalmng.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private Session session;

    @Override
    public boolean save(Student student) {
        try {
            Transaction transaction = session.beginTransaction();
            Serializable save = session.save(student);
            transaction.commit();
            return save != null;
        }catch (Exception e){
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Student student) {
        try {
            Transaction transaction = session.beginTransaction();
            session.update(student);
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
            Student student = session.get(Student.class, s);
            session.delete(student);
            transaction.commit();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public Student find(String s) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        query.from(Student.class);
        List<Student> resultList = session.createQuery(query).getResultList();
        transaction.commit();
        session.close();
        return resultList;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
