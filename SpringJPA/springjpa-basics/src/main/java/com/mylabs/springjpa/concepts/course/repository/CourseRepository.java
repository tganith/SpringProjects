package com.mylabs.springjpa.concepts.course.repository;

import com.mylabs.springjpa.concepts.course.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(int id){
        return em.find(Course.class,id);
    }

    public Course save(Course course){
        return em.merge(course);
    }

    public void deleteById(int id){
        Course course = findById(id);
        em.remove(course);
    }


    public List<Course> findAll(){
        TypedQuery<Course> typedQuery = em.createNamedQuery("find_all_courses",Course.class);
        return typedQuery.getResultList();
    }


}
