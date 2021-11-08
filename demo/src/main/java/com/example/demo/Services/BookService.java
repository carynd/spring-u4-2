package com.example.demo.Services;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getallbooks() {
        List<Book> booksall=bookRepository.findAll();
        return booksall;
    }

    public Book getbyid(int id) {
        Optional<Book> book1=bookRepository.findById(id);
        if(book1.isEmpty()){
            return null;
        }
        else return book1.get();
    }



    public String deletebyid(int id) {
        Book book1=bookRepository.findById(id).get();

        try{
            bookRepository.delete(book1);
            return "deleted successfully";
        }
        catch (Exception ex){
            return "wrong";
        }
    }

    public String updatebyid(Book book1) {
        Optional<Book> book2=bookRepository.findById(book1.getId());
        if(book2.isEmpty()) {
            return "wrong";
        }
        else{
            book2.get().setId(book1.getId());
            book2.get().setBrand(book1.getBrand());
            book2.get().setCategory(book1.getCategory());
            book2.get().setManu_id(book1.getManu_id());
            book2.get().setReg_no(book1.getReg_no());
            book2.get().setPrice(book1.getPrice());
            return "updated successfully";
        }
    }

    public Book postbook(Book book) {
        Book book1=bookRepository.save(book);
        return book1;
    }
}
