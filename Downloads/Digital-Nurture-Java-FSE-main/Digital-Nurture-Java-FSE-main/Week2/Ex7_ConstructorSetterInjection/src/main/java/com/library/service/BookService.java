package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    // Injected via constructor
    private BookRepository bookRepository;

    // Injected via setter
    private String libraryName;

    // Constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Constructor injection - BookRepository injected.");
    }

    // Setter injection
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        System.out.println("BookService: Setter injection - libraryName set to: " + libraryName);
    }

    public void addBook(String title) {
        System.out.println("[" + libraryName + "] BookService: Adding - " + title);
        bookRepository.addBook(title);
    }

    public void listBooks() {
        System.out.println("[" + libraryName + "] BookService: Listing books.");
        bookRepository.listBooks();
    }
}
