package com.splot.todoaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ToDoaAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToDoaAppApplication.class, args);
    }

}
