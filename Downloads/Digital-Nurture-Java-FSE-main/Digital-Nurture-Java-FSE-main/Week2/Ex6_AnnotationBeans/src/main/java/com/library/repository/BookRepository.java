package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void addBook(String title) {
        System.out.println("BookRepository: Adding book - " + title);
    }
    public void listBooks() {
        System.out.println("BookRepository: Listing all books.");
    }
}
