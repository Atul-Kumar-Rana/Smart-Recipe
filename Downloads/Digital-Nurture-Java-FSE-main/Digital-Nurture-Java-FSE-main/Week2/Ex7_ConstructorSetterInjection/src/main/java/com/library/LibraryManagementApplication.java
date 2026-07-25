package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // BookService receives BookRepository via constructor, libraryName via setter
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.addBook("Java: The Complete Reference");
        bookService.listBooks();
    }
}
