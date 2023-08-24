package lk.ijse.d24hostalmng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "room")
public class Room implements SuperEntity{
    @Id
    @Column(name = "room_id" , nullable = false,length = 50)
    private String roomId;
    @Column(name = "room_type" , nullable = false,length = 50)
    private String roomType;
    @Column(name = "key_money" ,nullable = false,length = 50)
    private Double keyMoney;
    @Column(name = "room_qty" ,nullable = false)
    private Integer qty;
    @Column(name = "room_availability",length = 50,nullable = false)
    private String roomAvailability;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "room")
    List<Reservation> reservations = new ArrayList<>();

    public Room(String roomId, String roomType, Double keyMoney, Integer qty, String roomAvailability) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.keyMoney = keyMoney;
        this.qty = qty;
        this.roomAvailability = roomAvailability;
    }
}
