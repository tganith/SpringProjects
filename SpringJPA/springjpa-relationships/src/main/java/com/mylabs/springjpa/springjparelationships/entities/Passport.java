package com.mylabs.springjpa.springjparelationships.entities;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private int id;

    private String passport_number;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
    private Student student;


    public Passport() {
    }

    public Passport(String passport_number) {
        this.passport_number = passport_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", passport_number='" + passport_number + '\'' +
            //    ", student=" + student +
                '}';
    }
}
