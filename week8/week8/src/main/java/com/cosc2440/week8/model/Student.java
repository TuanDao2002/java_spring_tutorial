package com.cosc2440.week8.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    public Student(){}

    // create getters for all attributes, so they can be returned to client side
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
