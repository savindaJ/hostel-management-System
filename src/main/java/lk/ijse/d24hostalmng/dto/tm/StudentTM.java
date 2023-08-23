package lk.ijse.d24hostalmng.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTM {
    private String studentNIC;
    private String studentNAme;
    private String address;
    private String contact;
    private Date dob;
    private String gender;
}
