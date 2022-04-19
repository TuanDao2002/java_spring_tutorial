package cosc2440.practice.courseManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "courseRegistration")
public class CourseRegistration {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id should always be integer
    private Long rid;

    // cannot use Cascade for join table in many-to-many relationship
    @ManyToOne
    @JsonIgnoreProperties(value = "registrationList") // ignore only the registration list of Student object
    private Student student;

    @ManyToOne
    @JsonIgnoreProperties(value = "registrationList") // ignore only the registration list of Course object
    private Course course;

    public CourseRegistration(){}

    public CourseRegistration(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
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


    // override equals and hashCode but only with Student and Course attributes to prevent duplicate Registration
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseRegistration that = (CourseRegistration) o;
        return student.equals(that.student) && course.equals(that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }
}
