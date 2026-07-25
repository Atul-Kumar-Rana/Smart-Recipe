package com.library.repository;

public class BookRepository {
    public void addBook(String title) {
        System.out.println("BookRepository: Book added - " + title);
    }
    public void listBooks() {
        System.out.println("BookRepository: Listing all books.");
    }
}
