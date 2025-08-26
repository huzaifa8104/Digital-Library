package com.example.Digital_Library.repository;

import com.example.Digital_Library.model.Book;
import com.example.Digital_Library.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitle(String title);

    List<Book> findByTitleContaining(String title);

    List<Book> findByBookType(BookType bookType);

    List<Book> findByBookNo(String bookNo);
}
