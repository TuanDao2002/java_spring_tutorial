package cosc2440.practice.courseManagementSystem.service;

import cosc2440.practice.courseManagementSystem.model.Course;
import cosc2440.practice.courseManagementSystem.model.CourseRegistration;
import cosc2440.practice.courseManagementSystem.model.Student;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegistrationService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String add(int studentID, int courseID) {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        Student retrieveStudent = sessionFactory.getCurrentSession().get(Student.class, studentID);
        if (retrieveStudent == null) {
            return "Student with ID: " + studentID + " does not exist!!!";
        }

        Course retrieveCourse = sessionFactory.getCurrentSession().get(Course.class, courseID);
        if (retrieveCourse == null) {
            return "Course with ID: " + courseID + " does not exist!!!";
        }

        CourseRegistration registration = new CourseRegistration(retrieveStudent, retrieveCourse);
        sessionFactory.getCurrentSession().save(registration);
        return "Registration with ID: " + registration.getRid() + " is added!!!";
    }

    public List<CourseRegistration> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CourseRegistration.class);
        return criteria.list();
    }

    public CourseRegistration getOne(String rid) {
        return sessionFactory.getCurrentSession().get(CourseRegistration.class, rid);
    }

    public String update(CourseRegistration CourseRegistration) {
        sessionFactory.getCurrentSession().saveOrUpdate(CourseRegistration);
        return "Registration with ID: " + CourseRegistration.getRid() + " is updated!!!";
    }

    public String delete(String rid) {
         CourseRegistration registration = getOne(rid);
        if (registration != null) {
            sessionFactory.getCurrentSession().evict(registration);
            sessionFactory.getCurrentSession().delete(registration);
            return "Registration with ID: " + registration .getRid() + " is deleted!!!";
        }

        return "Registration with ID: " + rid + " does not exist!!!";
    }
}
