package com.mylabs.springjpa.springjparelationships;

import com.mylabs.springjpa.springjparelationships.entities.Passport;
import com.mylabs.springjpa.springjparelationships.entities.Student;
import com.mylabs.springjpa.springjparelationships.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	EntityManager em;

	@Autowired
	StudentRepository studentRepository;

    @Test
    @Transactional
    void test_studentSave() {
        studentRepository.save(new Student("myname"));

    }

	/*@Test
	@Transactional
	void test_retrieveStudentAndPassport() {
		Student student = em.find(Student.class,2);
		System.out.println(student);
		System.out.println(student.getPassport());

	}*/


	@Test
	@Transactional
	void test_retrievePassportAndStudent() {
		Passport passport = em.find(Passport.class,10000);
		System.out.println(passport);
		System.out.println(passport.getStudent());

	}

}
