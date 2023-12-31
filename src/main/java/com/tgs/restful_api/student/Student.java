package com.tgs.restful_api.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    private String email;
    private LocalDate date_birth;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(long id, String name, String email, LocalDate date_birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date_birth = date_birth;
    }

    public Student(String name, String email, LocalDate date_birth) {
        this.name = name;
        this.email = email;
        this.date_birth = date_birth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(LocalDate date_birth) {
        this.date_birth = date_birth;
    }

    public Integer getAge() {
        return Period.between(this.date_birth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date_birth=" + date_birth +
                ", age=" + age +
                '}';
    }
}