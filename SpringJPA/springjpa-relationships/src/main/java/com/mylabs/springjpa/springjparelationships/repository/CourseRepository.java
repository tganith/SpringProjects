package com.mylabs.springjpa.springjparelationships.repository;

import com.mylabs.springjpa.springjparelationships.entities.Course;
import com.mylabs.springjpa.springjparelationships.entities.Passport;
import com.mylabs.springjpa.springjparelationships.entities.Reviews;
import com.mylabs.springjpa.springjparelationships.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course save(Course course){
        return em.merge(course);
    }

    public Course findById(int courseId){
        return em.find(Course.class,courseId);
    }

    public void delete(int courseId){
        Course course = em.find(Course.class,courseId);
        em.remove(course);
    }


    public void saveReviewsAndCourse(int courseId,List<Reviews> reviews){

        Course course = em.find(Course.class,courseId);

        for(Reviews review :reviews){
            course.addReviews(review);
            review.setCourse(course);
            em.persist(review);
        }
     }


    public void insertStudentAndCourse(Student student,Course course) {

        em.persist(student);
        em.persist(course);

        student.addCourses(course);
        course.addStudent(student);

        em.persist(student);

    }
}
