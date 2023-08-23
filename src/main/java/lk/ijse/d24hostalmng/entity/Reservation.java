package lk.ijse.d24hostalmng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @Column(name = "reservation_id",length = 50)
    private String reservationID;
    @Column(name = "reservation_date")
    private Date date;
    @Column(name = "reservation_status",length = 50)
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    Student student;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Room room;
}
