package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom query method: find books by author
    List<Book> findByAuthor(String author);

    // Custom query method: find books by title containing keyword
    List<Book> findByTitleContaining(String keyword);
}
