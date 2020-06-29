package com.mylabs.springjpa.course;

import com.mylabs.springjpa.concepts.course.SpringJPACourseApplication;
import com.mylabs.springjpa.concepts.course.entity.Course;
import com.mylabs.springjpa.concepts.course.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = SpringJPACourseApplication.class)
class SpringCourseApplicationTests {


	@Autowired
	CourseRepository repository;

	@Test
	void test_findById() {
		Course course = repository.findById(1);
		assertEquals("Core Java",course.getName());
	}

	@Test
	@DirtiesContext
	void test_deleteById() {
		repository.deleteById(1);
		assertNull(repository.findById(1));
	}

	@Test
	@DirtiesContext
	void test_saveCourse() {

		Course savedCourse = repository.save(new Course("testing"));

		Course course = repository.findById(savedCourse.getId());
		assertEquals(course.getName(),"testing");
	}


}
