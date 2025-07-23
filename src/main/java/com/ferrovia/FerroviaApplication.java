package com.ferrovia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FerroviaApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.ferrovia.FerroviaApplication.class, args);
    }
}
