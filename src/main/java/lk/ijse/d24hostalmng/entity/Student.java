package lk.ijse.d24hostalmng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_nic" , length = 40)
    private String studentNIC;
    @Column(name = "student_name" ,length = 50 ,nullable = false)
    private String studentNAme;
    @Column(name = "student_address" ,length = 50 ,nullable = false)
    private String address;
    @Column(name = "student_dob" , nullable = false)
    private Date dob;
    @Column(name = "student_gender" ,nullable = false)
    private String gender;

}
