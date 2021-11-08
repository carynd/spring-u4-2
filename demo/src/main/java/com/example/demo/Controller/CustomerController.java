package com.example.demo.Controller;

import com.example.demo.DTO.Product;
import com.example.demo.Entity.Book;
import com.example.demo.Services.BookService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    BookService bookService;


    @GetMapping("/products/customer/{id}")
    public MappingJacksonValue getallbookbyidcustomer(@PathVariable("id") int id){
        Book m1=bookService.getbyid(id);

        Product product=new Product(m1);

        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name","brand","category","price");
        FilterProvider filters=new SimpleFilterProvider().addFilter("productfilter",filter);
    }

}
