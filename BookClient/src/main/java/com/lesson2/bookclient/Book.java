package com.lesson2.bookclient;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class Book {
    @Id
    private String isbn;
    private String author;
    private String title;
    private double price;

    public Book(String isbn, String author, String title, double price) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public Book() {

    }
}
