package com.example.lab66;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Lab66Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab66Application.class, args);
    }

}
