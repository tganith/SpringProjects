package com.mylabs.springjpa.springjparelationships.repository;

import com.mylabs.springjpa.springjparelationships.entities.Passport;
import com.mylabs.springjpa.springjparelationships.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student save(Student student){
        return em.merge(student);
    }

    public Student findById(int studentId){
        return em.find(Student.class,studentId);
    }

    public void delete(int studentId){
        Student student = em.find(Student.class,studentId);
        em.remove(student);
    }

    public List<Student> findAll(){
       TypedQuery<Student> typedQuery = em.createNamedQuery("find_all_students",Student.class);
       return typedQuery.getResultList();
    }


    public void savePassportAndStudent(){
        Passport passport = new Passport("ABCD1234");
        em.persist(passport);

        Student student = new Student("mystudent");
        student.setPassport(passport);
        em.persist(student);

    }


}
