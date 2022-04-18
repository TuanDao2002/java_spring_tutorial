package cosc2440.practice.courseManagementSystem.service;

import cosc2440.practice.courseManagementSystem.model.Course;
import cosc2440.practice.courseManagementSystem.model.CourseRegistration;
import cosc2440.practice.courseManagementSystem.model.Student;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String add(Student student) {
        sessionFactory.getCurrentSession().save(student);
        return "Student with ID: " + student.getSid() + " is added!!!";
    }

    public List<Student> getAll(String name, Date startdate, Date endDate) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);

        // return Student objects with name matched anywhere using Restrictions.like (alternate for "LIKE" in SQL)
        if (name != null) criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));

        // return Student objects with birthdate greater than or equal using Restrictions.ge (alternate for ">=" in SQL)
        if (startdate != null) criteria.add(Restrictions.ge("birthdate", startdate));

        // return Student objects with birthdate less than or equal using Restrictions.le (alternate for "<=" in SQL)
        if (endDate != null) criteria.add(Restrictions.le("birthdate", endDate));

        // set this to prevent duplicate records when the results are sent back to client side
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    public List<Student> getAllStudent(int courseID) {
        Course retrieveCourse = sessionFactory.getCurrentSession().get(Course.class, courseID);
        if (retrieveCourse == null) {
            System.out.println("Course with ID: " + courseID + " does not exist!!!");
            return new ArrayList<>();
        }

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CourseRegistration.class);

        // create alias for Student object in CourseRegistration to access all of its columns individually
        criteria.createAlias("student", "s");

        /*
        // this solution will not return JSON format
        // only return id and name of "student" from registrations in array format
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("s.id"), "id")
                .add(Projections.property("s.name"), "name")
        );
         */

        // this is not included in the previous commented solution
        // return the whole Student object but columns that are specified to be displayed are determined by View
        criteria.setProjection(Projections.property("student"));

        // only return registrations that has the required course
        criteria.add(Restrictions.eq("course", retrieveCourse));

        // this sort will be executed first
        // order the students by name in ascending order
        criteria.addOrder(Order.asc("s.name"));

        // order the students by id in descending order
        criteria.addOrder(Order.desc("s.id"));

        return criteria.list();
    }


    public Student getOne(int sid) {
        return sessionFactory.getCurrentSession().get(Student.class, sid);
    }

    public String update(Student student) {
        Student retrieveStudent = getOne(student.getSid());
        if (retrieveStudent == null) {
            return "Student with ID: " + student.getSid() + " does not exist!!!";
        }

        // only allow to update name and birthdate from StudentService
        if(student.getName() != null) retrieveStudent.setName(student.getName());
        if(student.getBirthdate() != null) retrieveStudent.setBirthdate(student.getBirthdate());

        // update on the retrieve Student object, so no need to evict()
        sessionFactory.getCurrentSession().update(retrieveStudent);
        return "Student with ID: " + student.getSid() + " is updated!!!";
    }

    public String delete(int sid) {
        // delete Student object in many-to-many relationship
        Student retrieveStudent = getOne(sid);
        if (retrieveStudent != null) {
            for (CourseRegistration registration : retrieveStudent.getRegistrationList()) {
                // delete all registrations in database
                sessionFactory.getCurrentSession().delete(registration);

                // delete all registrations in the List of each POJO Course object
                registration.getCourse().getRegistrationList().remove(registration);

                /* Can retrieve the Course from database and delete CourseRegistration from it
                Course course = sessionFactory.getCurrentSession().get(Course.class, registration.getCourse().getCid());
                course.getRegistrationList().remove(registration);
                */
            }

            // does not need to use clear()
//            retrieveStudent.getRegistrationList().clear();

            // delete the retrieve Student object, so no need to evict()
            sessionFactory.getCurrentSession().delete(retrieveStudent);
            return "Student with ID: " + retrieveStudent.getSid() + " is deleted!!!";
        }

        return "Student with ID: " + sid + " does not exist!!!";
    }
}
