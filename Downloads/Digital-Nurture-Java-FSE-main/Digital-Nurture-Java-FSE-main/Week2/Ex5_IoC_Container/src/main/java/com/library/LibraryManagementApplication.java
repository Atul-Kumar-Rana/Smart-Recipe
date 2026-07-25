package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Spring IoC container loads and manages beans
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");
        bookService.addBook("Design Patterns");
        bookService.listBooks();

        System.out.println("Total beans managed by IoC container: " + context.getBeanDefinitionCount());
    }
}
