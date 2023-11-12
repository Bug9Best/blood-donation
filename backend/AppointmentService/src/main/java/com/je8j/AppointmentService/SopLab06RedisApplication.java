package com.je8j.AppointmentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
//@EnableCaching
public class SopLab06RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SopLab06RedisApplication.class, args);
    }

}
