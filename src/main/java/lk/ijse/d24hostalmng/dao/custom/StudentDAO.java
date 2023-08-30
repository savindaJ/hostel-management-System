package lk.ijse.d24hostalmng.dao.custom;

import lk.ijse.d24hostalmng.dao.CrudDAO;
import lk.ijse.d24hostalmng.entity.Student;

public interface StudentDAO extends CrudDAO<Student,String> {
    String getStuToatal();
}
