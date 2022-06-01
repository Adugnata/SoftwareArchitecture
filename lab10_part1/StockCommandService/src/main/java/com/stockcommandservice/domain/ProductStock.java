package com.stockcommandservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class ProductStock {
    @Id
    private String productNumber;
    private String name;
    private int price;
    private int numberInStock;

    public ProductStock(Stock stock) {
        this.productNumber = stock.getProductNumber();
        this.numberInStock = stock.getQuantity();
    }

    public void updateStock(Stock stock) {
        setProductNumber(stock.getProductNumber());
        setNumberInStock(stock.getQuantity());
    }
}
