package com.mylabs.springjpa.springjparelationships;

import com.mylabs.springjpa.springjparelationships.entities.Course;
import com.mylabs.springjpa.springjparelationships.entities.Passport;
import com.mylabs.springjpa.springjparelationships.entities.Reviews;
import com.mylabs.springjpa.springjparelationships.entities.Student;
import com.mylabs.springjpa.springjparelationships.repository.CourseRepository;
import com.mylabs.springjpa.springjparelationships.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJPARelationshipsApplication implements CommandLineRunner {

	@Autowired
	EntityManager em;

	@Autowired
	StudentRepository studentRepository;


	@Autowired
	CourseRepository courseRepository;


	public static void main(String[] args) {
		SpringApplication.run(SpringJPARelationshipsApplication.class, args);
	}


	@Override
	@Transactional
	public void run(String... args) throws Exception {

		/* basic operations of student

		studentRepository.save(new Student("myname"));

		System.out.println(studentRepository.findById(100));
		System.out.println(studentRepository.findAll());

		System.out.println("--------------------");

		studentRepository.delete(1);
		System.out.println(studentRepository.findAll());

        */

		//	System.out.println("--------------------------------------------------------------------------------");

		// relationships for one to one

		//studentRepository.savePassportAndStudent();

		//System.out.println(studentRepository.findAll());


		// uni directional student and passport
		/*Student student = studentRepository.findById(100);

		System.out.println(student);
		System.out.println(student.getPassport());*/

		// Bi directional passport and student
		/*Passport passport = em.find(Passport.class,10000);
		System.out.println(passport);
		System.out.println(passport.getStudent());*/

	//	System.out.println("--------------------------------------------------------------------------------");

		/*List<Reviews> reviewsList = new ArrayList<>();
		reviewsList.add(new Reviews("2","good"));
		reviewsList.add(new Reviews("3","ok"));

		courseRepository.saveReviewsAndCourse(10002,reviewsList);

		// one to many relationship
		*//*Course course  = em.find(Course.class,	10002);
		System.out.println(course);
		System.out.println(course.getReviews());*//*

		// Other side of relationship

		Reviews review = em.find(Reviews.class,1);
		System.out.println(review.getCourse());*/

		//	System.out.println("--------------------------------------------------------------------------------");

        // many to many relationships
/*
		Student student = em.find(Student.class,100);
		System.out.println(student);
		System.out.println(student.getCourses());


		Course course = em.find(Course.class,10001);
		System.out.println(course);
		System.out.println(course.getStudent());

		courseRepository.insertStudentAndCourse(new Student("Jayansh"),new Course("Microservices"));*/
	}


}
