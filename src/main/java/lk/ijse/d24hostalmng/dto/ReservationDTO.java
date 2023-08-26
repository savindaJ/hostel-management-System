package lk.ijse.d24hostalmng.dto;

import lk.ijse.d24hostalmng.entity.Room;
import lk.ijse.d24hostalmng.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private String reservationID;
    private Date date;
    private String status;
    private Date expDate;
    Student student;
    Room room;
}
