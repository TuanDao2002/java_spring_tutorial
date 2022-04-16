package cosc2440.practice.courseManagementSystem.service;

import cosc2440.practice.courseManagementSystem.model.Student;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public List<Student> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
        return criteria.list();
    }

    public Student getOne(int sid) {
        return sessionFactory.getCurrentSession().get(Student.class, sid);
    }

    public String update(Student student) {
        sessionFactory.getCurrentSession().saveOrUpdate(student);
        return "Student with ID: " + student.getSid() + " is updated!!!";
    }

    public String delete(int sid) {
        Student retrieveStudent = getOne(sid);
        if (retrieveStudent != null) {
            sessionFactory.getCurrentSession().evict(retrieveStudent);
            sessionFactory.getCurrentSession().delete(retrieveStudent);
            return "Student with ID: " + retrieveStudent.getSid() + " is deleted!!!";
        }

        return "Student with ID: " + sid + " does not exist!!!";
    }
}
