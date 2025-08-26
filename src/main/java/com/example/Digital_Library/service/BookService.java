package com.example.Digital_Library.service;

import com.example.Digital_Library.dto.BookRequest;
import com.example.Digital_Library.exception.TxnException;
import com.example.Digital_Library.model.*;
import com.example.Digital_Library.repository.AuthorRepository;
import com.example.Digital_Library.repository.BookRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Transactional(rollbackOn = {TxnException.class})

    public Book addBook(@Valid BookRequest bookRequest) {
        Author authorFromDB = authorRepository.getAuthorByEmail(bookRequest.getAuthorEmail());

        if(authorFromDB == null){
            authorFromDB = authorRepository.save(bookRequest.toAuthor());
        }

        Book book = bookRequest.toBook();
        book.setAuthor(authorFromDB);
        return bookRepository.save(book);
    }


    public List<Book> filter(BookFilterType bookFilterType, Operator operator, String value) {
        switch (bookFilterType){
            case BOOK_TITLE :
                switch (operator){
                    case EQUALS :
                        return bookRepository.findByTitle((value));
                    case LIKE:
                        return bookRepository.findByTitleContaining(value);
                    default:
                        return new ArrayList<>();
                }
            case BOOK_TYPE:
                switch (operator) {
                    case EQUALS:
                        return bookRepository.findByBookType(BookType.valueOf(value));
                }
            case BOOK_NO:
                switch (operator) {
                    case EQUALS:
                        return bookRepository.findByBookNo(value);
                }
        }
        return new ArrayList<>();
    }

    public void updateBookData(Book bookFromDb) {
        bookRepository.save(bookFromDb);
    }
}
