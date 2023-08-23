package lk.ijse.d24hostalmng.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class EmbeddedPK implements Serializable {
    @Column(name = "reservation_id")
    private String reservationID;
    @Column(name = "student_id")
    private String studentNic;
}
