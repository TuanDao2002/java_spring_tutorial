package com.cosc2440.week6.service;

import com.cosc2440.week6.entity.Course;
import com.cosc2440.week6.entity.Student;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CourseService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveCourse(Course course) {
        sessionFactory.getCurrentSession().save(course);
    }

    public void deleteCourse(Course course) {
        sessionFactory.getCurrentSession().delete(course);
    }

    public List<Course> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
        return criteria.list();
    }
}
