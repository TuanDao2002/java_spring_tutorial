package com.cosc2440.week8.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String content;

    // cascade type is all so every answer can be deleted along with question
    // fetch type is eager so question can load children answers in hibernate
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Answer> answers;

    public Question(){}

    // getters for all attributes, so they can be returned to client side
    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    public List<Answer> getAnswers() {
        return answers;
    }
}
