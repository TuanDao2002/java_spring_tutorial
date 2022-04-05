package com.cosc2440.week6.config;

import com.cosc2440.week6.entity.Person;
import com.cosc2440.week6.service.CourseService;
import com.cosc2440.week6.service.PersonService;
import com.cosc2440.week6.service.StudentService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public Person person() {
        return new Person();
    }

    @Bean
    public PersonService personService() {
        return new PersonService();
    }

    @Bean
    public StudentService studentService() { return new StudentService(); }

    @Bean
    public CourseService courseService() { return new CourseService(); }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager tx = new HibernateTransactionManager(sessionFactory);
        return tx;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        //To use postgresql
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("khatun");
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setHibernateProperties(properties);
        sessionFactoryBean.setPackagesToScan("com.cosc2440.week6.entity");
        return  sessionFactoryBean;
    }
}
