package com.webshopclient.product;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productNumber;
    private String description;
    private double price;
    private Supplier supplier;
    private Stock stock;
    private List<Review> reviews;
}
