package com.example.demo.Controller;

import com.example.demo.Entity.Book;
import com.example.demo.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;


    @GetMapping("/products")
    public List<Book> getallbooks(){
        List <Book> booklistdata=bookService.getallbooks();
        return booklistdata;
    }
}
