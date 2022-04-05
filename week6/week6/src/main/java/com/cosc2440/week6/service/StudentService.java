package com.cosc2440.week6.service;

import com.cosc2440.week6.entity.Student;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveStudent(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    public Student getStudentById(int id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }

    public void delete(Student student) {
        sessionFactory.getCurrentSession().delete(student);
    }

    public List getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
        return criteria.list();
    }
}
