package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
        System.out.println("Library Management Spring Boot App started!");
        System.out.println("H2 Console: http://localhost:8080/h2-console");
        System.out.println("Books API:  http://localhost:8080/api/books");
    }
}
