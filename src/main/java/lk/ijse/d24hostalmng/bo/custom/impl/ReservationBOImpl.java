package lk.ijse.d24hostalmng.bo.custom.impl;

import lk.ijse.d24hostalmng.bo.BOFactory;
import lk.ijse.d24hostalmng.bo.custom.ReservationBO;
import lk.ijse.d24hostalmng.bo.custom.RoomBO;
import lk.ijse.d24hostalmng.configuration.Configure;
import lk.ijse.d24hostalmng.dao.DAOFactory;
import lk.ijse.d24hostalmng.dao.custom.ReservationDAO;
import lk.ijse.d24hostalmng.dao.custom.RoomDAO;
import lk.ijse.d24hostalmng.dao.custom.StudentDAO;
import lk.ijse.d24hostalmng.dto.ReservationDTO;
import lk.ijse.d24hostalmng.dto.StudentDTO;
import lk.ijse.d24hostalmng.entity.Room;
import lk.ijse.d24hostalmng.entity.Student;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.RESERVATIONDAO);
    StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENTDAO);
    RoomDAO roomDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ROOMDAO);

    @Override
    public boolean save(ReservationDTO reservationDTO) {
        return false;
    }

    @Override
    public boolean update(ReservationDTO reservationDTO) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public ReservationDTO find(String s) {
        return null;
    }

    @Override
    public List<ReservationDTO> getAll() {
        return null;
    }

    @Override
    public String getNextResID() {
        Session session = Configure.getInstance().getSession();
        reservationDAO.setSession(session);
        String id = reservationDAO.getNextId();
        Integer newId = Integer.parseInt(id.replace("RES", "")) + 1;
        return String.format("RES%03d", newId);
    }

    @Override
    public List<String> getStudentIDs() {
        List<String> idList = new ArrayList<>();
        Session session = Configure.getInstance().getSession();
        studentDAO.setSession(session);
        for (Student student : studentDAO.getAll()) {
            idList.add(student.getStudentNIC());
        }
        return idList;
    }

    @Override
    public StudentDTO getStudent(String stuNic) {
        Session session = Configure.getInstance().getSession();
        studentDAO.setSession(session);
        Student student = studentDAO.find(stuNic);
        return new StudentDTO(
                student.getStudentNIC(),
                student.getStudentNAme(),
                student.getAddress(),
                student.getContact(),
                student.getDob(),
                student.getGender()
        );
    }

    @Override
    public List<String> getRoomIds() {
        List<String> roomIds = new ArrayList<>();
        Session session = Configure.getInstance().getSession();
        roomDAO.setSession(session);
        for (Room room : roomDAO.getAll()){
            roomIds.add(room.getRoomId());
        }
        return roomIds;
    }
}
