package com.mylabs.springjpa.basics.jpa.repository;

import com.mylabs.springjpa.basics.jpa.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJPARepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int personId) {
        return entityManager.find(Person.class,personId);
    }

    public Person insert(Person person) {
          return entityManager.merge(person);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int personId){
        Person person = findById(personId);
        entityManager.remove(person);
    }

    public List<Person> findAll(){
        TypedQuery<Person> personTypedQuery = entityManager.createNamedQuery("find_all_person",Person.class);
        return personTypedQuery.getResultList();
    }

}
