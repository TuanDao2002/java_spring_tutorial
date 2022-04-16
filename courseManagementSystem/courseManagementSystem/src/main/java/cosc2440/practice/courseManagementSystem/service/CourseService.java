package cosc2440.practice.courseManagementSystem.service;

import cosc2440.practice.courseManagementSystem.model.Course;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String add(Course course) {
        sessionFactory.getCurrentSession().save(course);
        return "Course with ID: " + course.getCid() + " is added!!!";
    }

    public List<Course> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
        return criteria.list();
    }

    public Course getOne(String cid) {
        return sessionFactory.getCurrentSession().get(Course.class, cid);
    }

    public String update(Course Course) {
        sessionFactory.getCurrentSession().saveOrUpdate(Course);
        return "Course with ID: " + Course.getCid() + " is updated!!!";
    }

    public String delete(String cid) {
        Course retrieveCourse = getOne(cid);
        if (retrieveCourse != null) {
            sessionFactory.getCurrentSession().evict(retrieveCourse);
            sessionFactory.getCurrentSession().delete(retrieveCourse);
            return "Course with ID: " + retrieveCourse.getCid() + " is deleted!!!";
        }

        return "Course with ID: " + cid + " does not exist!!!";
    }
}
