package com.cosc2440.week8.config;

import com.cosc2440.week8.model.Answer;
import com.cosc2440.week8.model.Question;
import com.cosc2440.week8.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

// exclude data source auto configuration so web MVC can function
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Configuration
@EnableTransactionManagement
@EnableWebMvc // enable WebMvc to perform crud from Postman API
public class AppConfig {
    // does not include controller or service in AppConfig
    // may not need to create Bean for objects
//    @Bean
//    public Student student() {
//        return new Student();
//    }

//    @Bean
//    public Question question() {
//        return new Question();
//    }
//
//    @Bean
//    public Answer answer() {
//        return new Answer();
//    }

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
        sessionFactoryBean.setPackagesToScan("com.cosc2440.week8.model");
        return  sessionFactoryBean;
    }
}
