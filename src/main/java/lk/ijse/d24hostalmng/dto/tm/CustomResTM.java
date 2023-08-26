package lk.ijse.d24hostalmng.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResTM {
    private String reservationID;
    private String studentNic;
    private String studentName;
    private String roomID;
    private String roomType;
    private Date currentDate;
    private Double keyMoney;
    private String keyMoneyStatus;
    private Date expDate;
}
