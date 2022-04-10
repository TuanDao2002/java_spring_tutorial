package com.cosc2440.week8.service;

import com.cosc2440.week8.model.Lecturer;
import com.cosc2440.week8.model.School;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AcademicService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addSchool(School school) {
        sessionFactory.getCurrentSession().saveOrUpdate(school);
        return school.getId();
    }

    public List<School> getAllSchools() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(School.class);
        return criteria.list();
    }

    public String addLecturer(Lecturer lecturer) {
        if (lecturer.getSchool() == null) {
            return "School is null!!!";
        }
        sessionFactory.getCurrentSession().saveOrUpdate(lecturer);
        return "Lecturer with ID: " + lecturer.getId() + " is added!!!";
    }

    public List<Lecturer> getAllLecturers() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Lecturer.class);
        return criteria.list();
    }
}
