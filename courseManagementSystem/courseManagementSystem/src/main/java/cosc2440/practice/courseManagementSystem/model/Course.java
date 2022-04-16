package cosc2440.practice.courseManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id should always be integer
    private int cid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int credit;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER) // fetch type is eager so Registration list can be returned to client side
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JsonIgnoreProperties(value = "course") // Registration list only shows Student objects here
    private Set<CourseRegistration> registrationList;

    public Course(){}

    public Course(int cid, String name) {
        this.cid = cid;
        this.name = name;
        registrationList = new HashSet<>();
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setRegistrationList(Set<CourseRegistration> registrationList) {
        this.registrationList = registrationList;
    }

    public Set<CourseRegistration> getRegistrationList() {
        return registrationList;
    }

}
