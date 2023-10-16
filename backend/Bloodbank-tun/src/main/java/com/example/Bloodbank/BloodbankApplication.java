package com.example.Bloodbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BloodbankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloodbankApplication.class, args);
    }

}
