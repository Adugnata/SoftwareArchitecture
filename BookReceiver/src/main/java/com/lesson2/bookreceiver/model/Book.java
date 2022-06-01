package com.lesson2.bookreceiver.model;

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
}
