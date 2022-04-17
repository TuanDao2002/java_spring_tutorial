package cosc2440.practice.courseManagementSystem.service;

import cosc2440.practice.courseManagementSystem.model.Course;
import cosc2440.practice.courseManagementSystem.model.CourseRegistration;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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

    public List<Course> getAll(String name, Integer minCredit, Integer maxCredit) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);

        // return Course objects with name matched anywhere using Restrictions.like (alternate for "LIKE" in SQL)
        if (name != null) criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));

        // return Course objects with credit greater than or equal minCredit using Restrictions.ge (alternate for ">=" in SQL)
        // Note: greater than operation e.g. ">" using Restrictions.gt
        if (minCredit != null) criteria.add(Restrictions.ge("credit", minCredit));

        // return Course objects with credit less than or equal maxCredit using Restrictions.le (alternate for "<=" in SQL)
        // Note: less than operation e.g. "<" using Restrictions.lt
        if (maxCredit != null) criteria.add(Restrictions.le("credit", maxCredit));

        // set this to prevent duplicate records when the results are sent back to client side
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    public Course getOne(int cid) {
        return sessionFactory.getCurrentSession().get(Course.class, cid);
    }

    public String update(Course course) {
        Course retrieveCourse = getOne(course.getCid());
        if (retrieveCourse == null) {
            return "Course with ID: " + course.getCid() + " does not exist!!!";
        }

        // only allow to update name and credit from CourseService
        if(course.getName() != null) retrieveCourse.setName(course.getName());
        if(course.getCredit() != 0) retrieveCourse.setCredit(course.getCredit());

        // update on the retrieve Course object, so no need to evict()
        sessionFactory.getCurrentSession().update(retrieveCourse);
        return "Course with ID: " + course.getCid() + " is updated!!!";
    }

    public String delete(int cid) {
        // delete Course object in many-to-many relationship
        Course retrieveCourse = getOne(cid);
        if (retrieveCourse != null) {
            for (CourseRegistration registration : retrieveCourse.getRegistrationList()) {
                // delete all registrations in database
                sessionFactory.getCurrentSession().delete(registration);

                // delete all registrations in the List of each Student object
                registration.getStudent().getRegistrationList().remove(registration);
            }

            // delete all registrations in the List of Course object
            retrieveCourse.getRegistrationList().clear();

            // delete the retrieve Course object, so no need to evict()
            sessionFactory.getCurrentSession().delete(retrieveCourse);
            return "Course with ID: " + retrieveCourse.getCid() + " is deleted!!!";
        }

        return "Course with ID: " + cid + " does not exist!!!";
    }
}
