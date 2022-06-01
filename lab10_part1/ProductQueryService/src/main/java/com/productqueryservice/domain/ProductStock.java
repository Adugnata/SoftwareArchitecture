package com.productqueryservice.domain;

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
}
