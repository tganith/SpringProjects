package com.mylabs.springjpa.springjparelationships;

import com.mylabs.springjpa.springjparelationships.entities.Course;
import com.mylabs.springjpa.springjparelationships.entities.Passport;
import com.mylabs.springjpa.springjparelationships.entities.Student;
import com.mylabs.springjpa.springjparelationships.repository.CourseRepository;
import com.mylabs.springjpa.springjparelationships.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	EntityManager em;

	@Autowired
	CourseRepository courseRepository;


	// course does not have students using jpql
	@Test
	@Transactional
	void test_courseDoesNotHaveStudents() {

		TypedQuery<Course>  typedQuery= em.createQuery("select c from Course c where c.student is empty",Course.class);
		System.out.println(typedQuery.getResultList());

	}


	// course opted more than two students
	@Test
	@Transactional
	void test_courseOptedMoreThanTwoStudents() {

		TypedQuery<Course>  typedQuery= em.createQuery("select c from Course c where size(c.student) > 2",Course.class);
		System.out.println(typedQuery.getResultList());

	}

	// course order by students using jpql
	@Test
	@Transactional
	void test_courseOrderByStudents() {

		TypedQuery<Course>  typedQuery= em.createQuery("select c from Course c  order by size(c.student) desc",Course.class);
		System.out.println(typedQuery.getResultList());

	}

	// course with like query with JPQL
	@Test
	@Transactional
	void test_getStudentsPassportNumberUisngLIKEOperator() {

		TypedQuery<Student>  typedQuery= em.createQuery("select s from Student s  where s.passport.passport_number like '%CD%' ",Student.class);
		System.out.println(typedQuery.getResultList());

	}

	// JOINS
	// course and student join
	@Test
	@Transactional
	void test_joinStudentAndCourse() {

		Query query = em.createQuery("select c,s from Course c JOIN c.student s ");
		List<Object[]> list = query.getResultList();

		for(Object[] object:list){
			System.out.println(object[0]);
			System.out.println(object[1]);
		}

	}

	// LEFT JOIN
	// course and student LEFT join
	@Test
	@Transactional
	void test_leftJoin() {

		Query query = em.createQuery("select c,s from Course c LEFT JOIN c.student s ");
		List<Object[]> list = query.getResultList();

		for(Object[] object:list){
			System.out.println(object[0]);
			System.out.println(object[1]);
		}

	}

	// RIGHT JOIN
	// course and student RIGHT join
	@Test
	@Transactional
	void test_rightJoin() {

		Query query = em.createQuery("select c,s from Course c RIGHT JOIN c.student s ");
		List<Object[]> list = query.getResultList();

		for(Object[] object:list){
			System.out.println(object[0]);
			System.out.println(object[1]);
		}

	}

	// CROSS JOIN
	// course and student CROSS join
	@Test
	@Transactional
	void test_crossJoin() {

		Query query = em.createQuery("select c,s from Course c , Student s ");
		List<Object[]> list = query.getResultList();

		for(Object[] object:list){
			System.out.println(object[0]);
			System.out.println(object[1]);
		}

	}


	@Test
	@Transactional
	void test_FirstLevelCahce() {

		Course course = em.find(Course.class,10001);
		System.out.println(course);

		Course course1 = em.find(Course.class,10001);
		System.out.println(course1);


	}

}
