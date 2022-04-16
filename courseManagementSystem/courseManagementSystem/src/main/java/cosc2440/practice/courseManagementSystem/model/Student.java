package cosc2440.practice.courseManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    private static final String datePattern = "MM/dd/yyyy";

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    // set a time zone to prevent offset datetime
    @JsonFormat(pattern = datePattern, lenient = OptBoolean.FALSE, timezone = "Asia/Ho_Chi_Minh")
    private Date birthdate;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<CourseRegistration> registrationList;

    public Student() {}

    public Student(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        registrationList = new ArrayList<>();
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<CourseRegistration> getRegistrationList() {
        return registrationList;
    }
}
