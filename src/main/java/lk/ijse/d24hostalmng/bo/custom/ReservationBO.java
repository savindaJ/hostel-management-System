package lk.ijse.d24hostalmng.bo.custom;

import lk.ijse.d24hostalmng.bo.CrudBO;
import lk.ijse.d24hostalmng.dto.*;

import java.util.List;

public interface ReservationBO extends CrudBO<ReservationDTO,String> {
    String getNextResID();

    List<String> getStudentIDs();

    StudentDTO getStudent(String stuNic);

    List<String> getRoomIds();

    RoomDTO getRoom(String value);

    List<CustomReservationDTO> getAllReservation();

    CustomReciveDTO findReciveReservation(String reservationID);

}
