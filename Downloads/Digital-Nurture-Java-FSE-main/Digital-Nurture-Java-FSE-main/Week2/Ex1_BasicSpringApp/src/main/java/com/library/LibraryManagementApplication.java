package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load Spring application context from XML
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService bean from context
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.performService();

        // Get BookRepository bean from context
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        bookRepository.displayBooks();

        System.out.println("Spring context loaded with " + context.getBeanDefinitionCount() + " beans.");
    }
}
