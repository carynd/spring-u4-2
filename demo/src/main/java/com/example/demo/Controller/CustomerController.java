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

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    BookService bookService;


    @GetMapping("/product/customer/{id}")
    public MappingJacksonValue getallbookbyidcustomer(@PathVariable("id") int id){
        Book m1=bookService.getbyid(id);

        Product product=new Product(m1);

        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name","brand","category","price");
        FilterProvider filters=new SimpleFilterProvider().addFilter("productfilter",filter);
        MappingJacksonValue mapping=new MappingJacksonValue(product);

        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/products/customer")
    public MappingJacksonValue getallbookcustomer(){
        List<Book> books= bookService.getallbooks();
        List <Product> products=new ArrayList<>();
        for(int i=0;i<books.size();i++){
            Product product=new Product(books.get(i));
            products.add(product);
        }


        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name","brand","category","price");
        FilterProvider filters=new SimpleFilterProvider().addFilter("productfilter",filter);
        MappingJacksonValue mapping=new MappingJacksonValue(products);

        mapping.setFilters(filters);
        return mapping;
    }

}
