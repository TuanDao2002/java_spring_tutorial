package com.cosc2440.week6.service;

import com.cosc2440.week6.entity.Person;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PersonService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void savePerson(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    public Person getPersonById(int id){
        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    public List getAll(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Person.class);
        return criteria.list();
    }

    public void update(Person person) {
        sessionFactory.getCurrentSession().update(person);
    }

    public void delete(Person person) {
        sessionFactory.getCurrentSession().delete(person);
    }

    public List<Person> getPersonByName1(String name){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Person.class);
        criteria.add(Restrictions.like("name",name, MatchMode.ANYWHERE));
        return criteria.list();
    }

    public List<Person> getPersonByName2(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from Person where name like:name");
        query.setString("name", "%"+name+"%");
        return query.list();
    }

    public List<Person> getPersonByName3(String name){
        // cannot use select * from as it return Objects
        // to match anywhere => select name from person where name like '%string_to_search%'
        // concatenate strings to each other
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select name from person where name like '%" + name + "%'");
        return query.list();
    }
}
