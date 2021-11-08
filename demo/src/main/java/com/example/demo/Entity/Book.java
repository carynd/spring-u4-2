package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Book {

    @Id
    private int id;
    private int price;
    private String name;
    private String brand;
    private String category;
    private String reg_no;
    private String manu_id;

    public Book(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getManu_id() {
        return manu_id;
    }

    public void setManu_id(String manu_id) {
        this.manu_id = manu_id;
    }

    /*
    id : 101,
		name: "Skull Candy Headphones",
    price: 10000,
    brand: "Skull Candy",
    category: "Headphones",
		registration_number: "2gh856",
		manufacturer_id: "MAN254
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
