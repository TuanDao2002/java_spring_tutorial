package com.cosc2440.week6.entity;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    public Person() {
    }

    Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
