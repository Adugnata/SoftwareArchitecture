package com.webshop.product.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String productNumber;
    private String description;
    private double price;
    private Supplier supplier;
    private Stock stock;
    private List<Review> reviews;
}
