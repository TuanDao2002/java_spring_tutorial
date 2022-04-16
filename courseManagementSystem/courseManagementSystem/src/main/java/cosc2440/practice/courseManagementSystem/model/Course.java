package cosc2440.practice.courseManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int credit;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<CourseRegistration> registrationList;

    public Course(){}

    public Course(int cid, String name) {
        this.cid = cid;
        this.name = name;
        registrationList = new ArrayList<>();
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

    public List<CourseRegistration> getRegistrationList() {
        return registrationList;
    }
}
