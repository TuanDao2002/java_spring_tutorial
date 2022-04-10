package com.cosc2440.week8.service;

import com.cosc2440.week8.model.Answer;
import com.cosc2440.week8.model.Question;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class QuestionService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addQuestion(Question question) {
        for (Answer answer : question.getAnswers()) {
            answer.setQuestion(question);
        }

        sessionFactory.getCurrentSession().save(question);
        return question.getId();
    }

    public List<Question> getAllQuestions() {
        return sessionFactory.getCurrentSession().createQuery("from Question ").list();
    }

    public int updateQuestion(Question question) {
        if (question.getAnswers() != null) {
            for (Answer answer : question.getAnswers()) {
                answer.setQuestion(question);
            }
        }

        sessionFactory.getCurrentSession().update(question);
        return question.getId();
    }
}
