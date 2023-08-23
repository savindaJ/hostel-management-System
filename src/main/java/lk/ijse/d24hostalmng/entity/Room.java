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
    private String keyMoney;
    @Column(name = "room_qty" ,nullable = false)
    private Integer qty;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "room")
    List<Reservation> reservations = new ArrayList<>();
}
