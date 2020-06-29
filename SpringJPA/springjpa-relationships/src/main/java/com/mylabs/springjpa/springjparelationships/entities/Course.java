package com.mylabs.springjpa.springjparelationships.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable
public class Course {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "course")
    private List<Reviews> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> student = new ArrayList<>();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void addReviews(Reviews reviews) {
        this.reviews.add(reviews);
    }

    public void removeReviews(Reviews reviews) {
        this.reviews.remove(reviews);
    }

    public List<Student> getStudent() {
        return student;
    }

    public void addStudent(Student student) {
        this.student.add(student);
    }

    public void remove(Student student) {
        this.student.remove(student);
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
             //   ", reviews=" + reviews +
                '}';
    }
}
