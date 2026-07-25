package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // BookRepository is automatically injected into BookService via setter DI
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.addBook("Spring in Action");
        bookService.addBook("Clean Code");
        bookService.listBooks();
    }
}
