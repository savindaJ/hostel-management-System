package lk.ijse.d24hostalmng.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String studentNIC;
    private String studentNAme;
    private String address;
    private Date dob;
    private String gender;
}
