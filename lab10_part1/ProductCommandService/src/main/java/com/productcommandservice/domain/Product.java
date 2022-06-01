package com.productcommandservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Product {
    @Id
    private String productNumber;
    private String name;
    private int price;
}
