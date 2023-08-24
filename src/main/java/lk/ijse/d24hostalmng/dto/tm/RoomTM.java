package lk.ijse.d24hostalmng.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomTM {
    private String roomId;
    private String roomType;
    private Double keyMoney;
    private Integer qty;
    private String roomAvailability;
}
