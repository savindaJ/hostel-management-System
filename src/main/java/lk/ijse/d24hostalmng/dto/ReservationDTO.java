package lk.ijse.d24hostalmng.dto;

import lk.ijse.d24hostalmng.entity.Room;
import lk.ijse.d24hostalmng.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private String reservationID;
    private LocalDate date;
    private String status;
    private String studentNic;
    private String roomId;

}
