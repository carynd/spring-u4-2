package com.example.demo.Controller;

import com.example.demo.Entity.Book;
import com.example.demo.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/product/{id}")
    public Book getbyid(@PathVariable("id") int id){
        Book book=bookService.getbyid(id);
        return book;
    }
    @PostMapping("/product")
    public Book postbook(@RequestBody Book book){
        Book bookadded=bookService.postbook(book);
        return bookadded;
    }

    @DeleteMapping("/product/{id}")
    public String deletebyid(@PathVariable("id") int id){
        String message1=bookService.deletebyid(id);
        return message1;
    }
    @PutMapping("/product")
    public String updatebyid(@RequestBody Book book1){
        String message1=bookService.updatebyid(book1);
        return message1;
    }

}
