package lk.ijse.d24hostalmng.bo.custom.impl;

import lk.ijse.d24hostalmng.bo.custom.StudentBO;
import lk.ijse.d24hostalmng.dto.StudentDTO;

import java.util.List;

public class StudentBOImpl implements StudentBO {
    @Override
    public boolean save(StudentDTO studentDTO) {
        return false;
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
        return null;
    }
}
