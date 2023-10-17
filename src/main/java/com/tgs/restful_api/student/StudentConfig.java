package com.tgs.restful_api.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student tgs = new Student(
                    "TGS",
                    "tgs@gmail.com",
                    LocalDate.of(2001, Month.AUGUST, 13)
            );

            Student ahmad = new Student(
                    "Ahmad",
                    "ahmad@gmail.com",
                    LocalDate.of(2003, Month.JANUARY, 10)
            );

            repository.saveAll(
                    List.of(tgs, ahmad)
            );
        };
    }
}