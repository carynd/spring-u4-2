package com.example.demo.Services;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getallbooks() {
        List<Book> booksall=bookRepository.findAll();
        return booksall;
    }
}
