package com.mylabs.springjpa.springjparelationships;

import com.mylabs.springjpa.springjparelationships.entities.Course;
import com.mylabs.springjpa.springjparelationships.entities.Student;
import com.mylabs.springjpa.springjparelationships.repository.CourseRepository;
import com.mylabs.springjpa.springjparelationships.repository.CourseSpringDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class CourseSpringDataRepositoryTest {

	@Autowired
	EntityManager em;

	@Autowired
	CourseSpringDataRepository courseSpringDataRepository;


    @Test
	@Transactional
	void test_findAllCourses() {

    	List<Course> coursesList= courseSpringDataRepository.findAll();
    	System.out.println(coursesList);

	}

	@Test
	@Transactional
	void test_findById() {

		Optional<Course> course = courseSpringDataRepository.findById(100061);
		System.out.println(course.isPresent());
		System.out.println(course);


	}


	@Test
	@Transactional
	void test_saveCourse() {

		Course course =  courseSpringDataRepository.save(new Course("spring batch"));
		System.out.println(course);

		course.setName("spring batch - updated");

		System.out.println(course);
	}


	@Test
	@Transactional
	public void test_basicOperations() {

    	// count of courses
		System.out.println("count of courses :"+courseSpringDataRepository.count());

		// descending order by id - sorting
		System.out.println(courseSpringDataRepository.findAll(Sort.by(Sort.Direction.DESC,"id")));

    }

	@Test
	@Transactional
	public void test_FindByName() {

    	// customized query
		List<Course> course = courseSpringDataRepository.findByName("Spring Boot");
		System.out.println(course);
	}

	@Test
	@Transactional
	public void test_pagination() {


		PageRequest  firstPage = PageRequest.of(0,2);
		Page<Course> page = courseSpringDataRepository.findAll(firstPage);
		System.out.println(page.getContent());

		PageRequest  secondPageReq = PageRequest.of(1,2);
		Page<Course> secondPage = courseSpringDataRepository.findAll(secondPageReq);
		System.out.println(secondPage.getContent());
/*
		PageRequest  secondPage = PageRequest.of(1,2);
		System.out.println(courseSpringDataRepository.findAll(secondPage));*/

	}
}
