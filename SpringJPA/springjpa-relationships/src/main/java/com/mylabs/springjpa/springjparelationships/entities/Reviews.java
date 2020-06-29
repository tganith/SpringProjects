package com.mylabs.springjpa.springjparelationships.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reviews {

     @Id
     @GeneratedValue
     private int id;
     private String ratings;
     private String description;

     @ManyToOne
     private Course course;

     public Reviews() {
     }

    public Reviews(String ratings, String description) {
        this.ratings = ratings;
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", ratings='" + ratings + '\'' +
                ", description='" + description + '\'' +
         //       ", course=" + course +
                '}';
    }
}
