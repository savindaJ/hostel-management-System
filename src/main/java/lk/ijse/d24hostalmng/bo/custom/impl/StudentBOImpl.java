package lk.ijse.d24hostalmng.bo.custom.impl;

import lk.ijse.d24hostalmng.bo.custom.StudentBO;
import lk.ijse.d24hostalmng.configuration.Configure;
import lk.ijse.d24hostalmng.dao.DAOFactory;
import lk.ijse.d24hostalmng.dao.custom.StudentDAO;
import lk.ijse.d24hostalmng.dto.StudentDTO;
import lk.ijse.d24hostalmng.entity.Student;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENTDAO);

    @Override
    public boolean save(StudentDTO studentDTO) {
        Session session = Configure.getInstance().getSession();
        studentDAO.setSession(session);
        return studentDAO.save(new Student(
                studentDTO.getStudentNIC(),
                studentDTO.getStudentNAme(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGender()
        ));
    }

    @Override
    public boolean update(StudentDTO studentDTO) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public StudentDTO find(String s) {
        return null;
    }

    @Override
    public List<StudentDTO> getAll() {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        Session session = Configure.getInstance().getSession();
        studentDAO.setSession(session);
        for (Student student : studentDAO.getAll()){
            studentDTOS.add(new StudentDTO(
                    student.getStudentNIC(),
                    student.getStudentNAme(),
                    student.getAddress(),
                    student.getContact(),
                    student.getDob(),
                    student.getGender()
            ));
        }
        return studentDTOS;
    }
}
