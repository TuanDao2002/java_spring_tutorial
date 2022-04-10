package com.cosc2440.week8.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String content;

    @ManyToOne
    @JsonIgnore
    // each question in answer will load another answers, which cause infinite loop
    // => JsonIgnore so question in answer does not load answers again
    private Question question;

    public Answer(){}

    public void setQuestion(Question question) {
        this.question = question;
    }

    // getters for all attributes, so they can be returned to client side
    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
