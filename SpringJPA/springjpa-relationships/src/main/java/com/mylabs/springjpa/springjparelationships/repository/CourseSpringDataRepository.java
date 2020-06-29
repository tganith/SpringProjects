package com.mylabs.springjpa.springjparelationships.repository;

import com.mylabs.springjpa.springjparelationships.entities.Course;
import com.mylabs.springjpa.springjparelationships.entities.Reviews;
import com.mylabs.springjpa.springjparelationships.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public interface CourseSpringDataRepository extends JpaRepository<Course,Integer> {

    List<Course> findByName(String name);
    List<Course> findByNameOrderByIdDesc(String name);

}
