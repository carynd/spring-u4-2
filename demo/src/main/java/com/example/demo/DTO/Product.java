package com.example.demo.DTO;

import com.example.demo.Entity.Book;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@JsonFilter("productfilter")
public class Product {
    private int id;
    private int price;
    private String name;
    private String brand;
    private String category;
    private String reg_no;
    private String manu_id;

    public Product(Book m1) {
        this.id=m1.getId();
        this.brand= m1.getBrand();
        this.category= m1.getCategory();
        this.name= m1.getName();
        this.manu_id= m1.getManu_id();
        this.price= m1.getPrice();
        this.reg_no= m1.getReg_no();
    }
}

