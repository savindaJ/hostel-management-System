package lk.ijse.d24hostalmng.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmbeddedPK {
    @Column(name = "reservation_id")
    private String reservationID;
    @Column(name = "student_id")
    private String studentNic;
}
