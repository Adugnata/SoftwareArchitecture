package com.productcommandservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document
public class ProductStock {
    @Id
    private String productNumber;
    private String name;
    private int price;
    private int numberInStock;

    public ProductStock(Product product) {
        this.productNumber = product.getProductNumber();
        this.name = product.getName();
        this.price = product.getPrice();
        this.numberInStock = 0;
    }

    public void updateProduct(Product product) {
        setProductNumber(product.getProductNumber());
        setName(product.getName());
        setPrice(product.getPrice());
    }
}
