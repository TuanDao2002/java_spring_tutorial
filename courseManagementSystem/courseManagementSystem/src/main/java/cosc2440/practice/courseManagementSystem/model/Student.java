package cosc2440.practice.courseManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.OptBoolean;
import cosc2440.practice.courseManagementSystem.config.View;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "student")
public class Student {
    private static final String datePattern = "MM/dd/yyyy";

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // this attribute will always be returned to client in JSON, unless it can be restricted in Criteria
    @JsonView(View.Public.class)
    // id should always be integer
    private int sid;

    @Column(nullable = false)
    // this attribute will always be returned to client in JSON, unless it can be restricted in Criteria
    @JsonView(View.Public.class)
    private String name;

    @Column(nullable = false)
    // set a local time zone to prevent offset datetime
    // set lenient to be false to prevent a day before error
    @JsonFormat(pattern = datePattern, lenient = OptBoolean.FALSE, timezone = "Asia/Ho_Chi_Minh")
    // this attribute will always be returned to client in JSON, unless it can be restricted in Criteria
    @JsonView(View.Public.class)
    private Date birthdate;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER) // fetch type is eager so Registration list can be returned to client side
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnoreProperties(value = "student") // Registration list only shows Course objects here
    // this attribute will not be returned if the Controller set Serialization View to View.Public.class
    // => allows only public attributes to be displayed
    @JsonView(View.Internal.class)
    private Set<CourseRegistration> registrationList;

    public Student() {}

    public Student(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        registrationList = new HashSet<>();
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

    public void setRegistrationList(Set<CourseRegistration> registrationList) {
        this.registrationList = registrationList;
    }

    public Set<CourseRegistration> getRegistrationList() {
        return registrationList;
    }
}
