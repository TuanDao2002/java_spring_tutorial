package cosc2440.practice.courseManagementSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "courseRegistration")
public class CourseRegistration {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String rid;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    public CourseRegistration(){}

    public CourseRegistration(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
