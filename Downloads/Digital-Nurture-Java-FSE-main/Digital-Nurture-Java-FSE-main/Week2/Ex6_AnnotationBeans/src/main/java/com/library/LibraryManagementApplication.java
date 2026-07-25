package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Spring scans com.library and detects @Service, @Repository automatically
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean(BookService.class);
        bookService.addBook("Spring Boot in Practice");
        bookService.listBooks();

        System.out.println("Annotation-based configuration successful!");
    }
}
