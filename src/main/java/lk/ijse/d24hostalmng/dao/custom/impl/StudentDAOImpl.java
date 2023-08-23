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
            session.close();
            return save != null;
        }catch (Exception e){
            return false;
        }
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
