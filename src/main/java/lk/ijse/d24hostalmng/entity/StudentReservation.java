package lk.ijse.d24hostalmng.entity;

import lk.ijse.d24hostalmng.embedded.EmbeddedPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "student_reservation")
public class StudentReservation {

    /*@EmbeddedId
    private EmbeddedPK embeddedPK;*/

    @Id
    @Column(name = "student_reservation_id" ,length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer stuResID;

    @ManyToOne
    @JoinColumn(name = "student_id",
            referencedColumnName = "student_id",
            insertable = false,
            updatable = false)
    private Student student;

    @ManyToOne
        @JoinColumn(name = "reservation_id",
                    referencedColumnName = "reservation_id",
                    insertable = false,
                    unique = true
        )
    private Reservation reservation;

}
