package com.mylabs.springjpa.springjparelationships.repository;

import com.mylabs.springjpa.springjparelationships.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRestRepository extends JpaRepository<Course,Integer> {

    List<Course> findByName(String name);
    List<Course> findByNameOrderByIdDesc(String name);

}
