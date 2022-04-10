package com.cosc2440.week8.service;

import com.cosc2440.week8.model.Student;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class StudentService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Student> getAllStudents() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
        return criteria.list();
    }

    public int saveStudent(Student student) {
        sessionFactory.getCurrentSession().save(student);
        return student.getId();
    }

    public Student getStudentById(int id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }

    public List<Student> getStudentByName(String findName) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
        criteria.add(Restrictions.like("name", findName, MatchMode.ANYWHERE));
        return criteria.list();
    }

    public String updateStudent(Student student) {
        if (student.getId() == 0) return "Missing id for this student!!!";
        sessionFactory.getCurrentSession().update(student);
        return "Student with id: " + student.getId() + " is updated!!!";
    }

    public String deleteStudentById(int id) {
        Student retrieveStudent = sessionFactory.getCurrentSession().get(Student.class, id);
        if (retrieveStudent == null) {
            return "Student with id: " + id + " is not found!!!";
        }

        sessionFactory.getCurrentSession().evict(retrieveStudent);
        sessionFactory.getCurrentSession().delete(retrieveStudent);
        return "Student with id: " + id + " is deleted!!!";
    }
}
