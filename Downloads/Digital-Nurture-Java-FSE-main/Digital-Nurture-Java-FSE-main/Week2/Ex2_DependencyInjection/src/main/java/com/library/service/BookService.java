package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    // Dependency to be injected by Spring
    private BookRepository bookRepository;

    // Setter method for Spring to inject BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        System.out.println("BookService: Requesting to add book - " + title);
        bookRepository.addBook(title);
    }

    public void listBooks() {
        System.out.println("BookService: Requesting list of books.");
        bookRepository.listBooks();
    }
}
