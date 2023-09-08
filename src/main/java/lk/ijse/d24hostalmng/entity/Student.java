package lk.ijse.d24hostalmng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student implements SuperEntity{
    @Id
    @Column(name = "student_id" , length = 40)
    private String studentNIC;
    @Column(name = "student_name" ,length = 50 ,nullable = false)
    private String studentNAme;
    @Column(name = "student_address" ,length = 50 ,nullable = false)
    private String address;
    @Column(name = "student_contact")
    private String contact;
    @Column(name = "student_dob" , nullable = false)
    private Date dob;
    @Column(name = "student_gender" ,nullable = false)
    private String gender;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "student")
    List<Reservation> reservations = new ArrayList<>();

    public Student(String studentNIC, String studentNAme, String address, String contact, Date dob, String gender) {
        this.studentNIC = studentNIC;
        this.studentNAme = studentNAme;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
    }
}
