package com.mylabs.springjpa.concepts.course;

import com.mylabs.springjpa.basics.jpa.entity.Person;
import com.mylabs.springjpa.basics.jpa.repository.PersonJPARepository;
import com.mylabs.springjpa.concepts.course.entity.Course;
import com.mylabs.springjpa.concepts.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringJPACourseApplication implements CommandLineRunner {

	@Autowired
    CourseRepository courseRepository;

	public static void main(String[] args) {

		SpringApplication.run(SpringJPACourseApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

        courseRepository.save(new Course("Core Java"));
        courseRepository.save(new Course("J2ee"));
        courseRepository.save(new Course("Spring Cloud"));
        courseRepository.save(new Course("Spring JPA"));

        System.out.println(courseRepository.findById(1));
      //  courseRepository.deleteById(1);

        System.out.println("--------------------");


        System.out.println(courseRepository.findAll());


	}
}
