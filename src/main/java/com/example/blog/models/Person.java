package com.example.blog.models;

import javax.persistence.*;

@Entity
@Table(name="people")
public class Person {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column(nullable=false)
    private int age;

    @Column(nullable=false)
    private String name;

    @Column(name="reside_state", nullable=false, columnDefinition="char(2)")
    private String resideState;

    public Person() {
    }

    public Person(String name, String resideState) {
        this.name = name;
        this.resideState = resideState;
    }

    public Person(int age, String name, String resideState) {
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}