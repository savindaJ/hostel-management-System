package lk.ijse.d24hostalmng.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private String roomId;
    private String roomType;
    private Double keyMoney;
    private Integer qty;
    private String availability;
}
