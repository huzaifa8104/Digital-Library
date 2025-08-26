package com.example.Digital_Library.controller;

import com.example.Digital_Library.dto.BookRequest;
import com.example.Digital_Library.model.Book;
import com.example.Digital_Library.model.BookFilterType;
import com.example.Digital_Library.model.Operator;
import com.example.Digital_Library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody @Valid BookRequest bookRequest){
        //validation before the business logic
//        if(StringUtil.isNullOrEmpty(bookRequest.getBookNo())){
//            throw new Exception("Book no should not be blank");
//        }

        Book book = bookService.addBook(bookRequest);

        return book;
    }

    @GetMapping("/filter")
    public List<Book> filter(@RequestParam("filterBy") BookFilterType bookFilterType,
                                  @RequestParam("operator")Operator operator,
                                  @RequestParam("value")String value){
        return bookService.filter(bookFilterType, operator, value);
    }

}
