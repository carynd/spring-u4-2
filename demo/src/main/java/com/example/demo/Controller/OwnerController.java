package com.example.demo.Controller;

import com.example.demo.DTO.Product;
import com.example.demo.Entity.Book;
import com.example.demo.Services.BookService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OwnerController {
    @Autowired
    BookService bookService;


    @GetMapping("/products/owner/{id}")
    public MappingJacksonValue getallbookbyidowner(@PathVariable("id") int id) {
        Book m1 = bookService.getbyid(id);

        Product product = new Product(m1);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "brand", "category", "price", "reg_no", "manu_no");
        FilterProvider filters = new SimpleFilterProvider().addFilter("productfilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(product);

        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/products/owner")
    public MappingJacksonValue getallbookowner() {
        List<Book> books = bookService.getallbooks();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Product product = new Product(books.get(i));
            products.add(product);
        }


        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "brand", "category", "price", "reg_no", "manu_no");
        FilterProvider filters = new SimpleFilterProvider().addFilter("productfilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(products);

        mapping.setFilters(filters);
        return mapping;
    }

    @PostMapping("/product/owner")
    public MappingJacksonValue postbookowner(@RequestBody Book book) {
        Book b1 = bookService.postbook(book);
        Product product = new Product(b1);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "brand", "category", "price", "reg_no", "manu_no");
        FilterProvider filters = new SimpleFilterProvider().addFilter("productfilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(product);

        mapping.setFilters(filters);
        return mapping;

    }

    @DeleteMapping("/product/owner/{id}")
    public MappingJacksonValue deletebyidowner(@PathVariable("id") int id) {
        String m1 = bookService.deletebyid(id);


        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "brand", "category", "price", "reg_no", "manu_no");
        FilterProvider filters = new SimpleFilterProvider().addFilter("productfilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(m1);

        mapping.setFilters(filters);
        return mapping;
    }

    @PutMapping("/product/owner")
    public MappingJacksonValue updatebyidowner(@RequestBody Book book) {
        String m2 = bookService.updatebyid(book);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "brand", "category", "price", "reg_no", "manu_no");
        FilterProvider filters = new SimpleFilterProvider().addFilter("productfilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(m2);

        mapping.setFilters(filters);
        return mapping;
    }
}