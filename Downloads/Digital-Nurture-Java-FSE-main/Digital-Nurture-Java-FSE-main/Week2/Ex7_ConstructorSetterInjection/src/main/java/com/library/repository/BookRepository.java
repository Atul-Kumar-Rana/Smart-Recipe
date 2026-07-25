package com.library.repository;

public class BookRepository {
    public void addBook(String title) {
        System.out.println("BookRepository: Persisting book - " + title);
    }
    public void listBooks() {
        System.out.println("BookRepository: Fetching all books from DB.");
    }
}
