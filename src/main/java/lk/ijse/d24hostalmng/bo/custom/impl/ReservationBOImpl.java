package lk.ijse.d24hostalmng.bo.custom.impl;

import lk.ijse.d24hostalmng.bo.custom.ReservationBO;
import lk.ijse.d24hostalmng.configuration.Configure;
import lk.ijse.d24hostalmng.dao.DAOFactory;
import lk.ijse.d24hostalmng.dao.custom.QuaryDAO;
import lk.ijse.d24hostalmng.dao.custom.ReservationDAO;
import lk.ijse.d24hostalmng.dao.custom.RoomDAO;
import lk.ijse.d24hostalmng.dao.custom.StudentDAO;
import lk.ijse.d24hostalmng.dto.*;
import lk.ijse.d24hostalmng.entity.Reservation;
import lk.ijse.d24hostalmng.entity.Room;
import lk.ijse.d24hostalmng.entity.Student;
import org.hibernate.Session;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.RESERVATIONDAO);
    StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENTDAO);
    RoomDAO roomDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ROOMDAO);
    QuaryDAO quaryDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QUARYDAO);

    @Override
    public boolean save(ReservationDTO reservationDTO) {
        System.out.println(reservationDTO);
        Date expDate = genarateExpDate(reservationDTO.getDate());
        System.out.println("key money expDate :"+expDate);

        Session session = Configure.getInstance().getSession();
        studentDAO.setSession(session);
        Student student = studentDAO.find(reservationDTO.getStudentNic());

        Session roomSession = Configure.getInstance().getSession();
        roomDAO.setSession(roomSession);
        Room room = roomDAO.find(reservationDTO.getRoomId());
        room.setQty(room.getQty()-1);
        Session roomUpdSession = Configure.getInstance().getSession();
        roomDAO.setSession(roomUpdSession);
        boolean update = roomDAO.update(room);

        if (update){

            Session resSession = Configure.getInstance().getSession();
            reservationDAO.setSession(resSession);

            return reservationDAO.save(new Reservation(
                    reservationDTO.getReservationID(),
                    Date.valueOf(reservationDTO.getDate()),
                    reservationDTO.getStatus(),
                    expDate,
                    student,
                    room
            ));
        }

        return false;
    }

    private Date genarateExpDate(LocalDate date) {
        LocalDate genarateDate = date.plusMonths(1);
        return Date.valueOf(genarateDate);
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

    @Override
    public RoomDTO getRoom(String value) {
        Session session = Configure.getInstance().getSession();
        roomDAO.setSession(session);
        Room room = roomDAO.find(value);
        return new RoomDTO(
                room.getRoomId(),
                room.getRoomType(),
                room.getKeyMoney(),
                room.getQty(),
                room.getRoomAvailability()
        );
    }

    @Override
    public List<CustomReservationDTO> getAllReservation() {
        Session session = Configure.getInstance().getSession();
        quaryDAO.setSession(session);
        List<CustomReservationDTO> dtos = quaryDAO.getAllReservation();
        return dtos;
    }

    @Override
    public CustomReciveDTO findReciveReservation(String reservationID) {
        Session session = Configure.getInstance().getSession();
        reservationDAO.setSession(session);
        Reservation reservation = reservationDAO.find(reservationID);
        return new CustomReciveDTO(
                reservation.getReservationID(),
                reservation.getDate(),
                reservation.getStatus(),
                reservation.getStudent().getStudentNIC(),
                reservation.getRoom().getRoomId()
        );
    }
}
