package com.mylabs.springjpa.basics;
/*

import com.mylabs.springjpa.basics.jpa.entity.Person;
import com.mylabs.springjpa.basics.jpa.repository.PersonJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringJPABasicsApplication implements CommandLineRunner {

	@Autowired
	PersonJPARepository personJPARepository;

	public static void main(String[] args) {

		SpringApplication.run(SpringJPABasicsApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {



        personJPARepository.insert(new Person("user1","bangalore",new Date()));

        personJPARepository.update(new Person("user2","bangalore",new Date()));

        Person person = personJPARepository.findById(1);

        System.out.println(person.getId());
        System.out.println(person.getName());

        personJPARepository.deleteById(1);

        System.out.println("--------------------");


        System.out.println(personJPARepository.findAll());


	}
}
*/
