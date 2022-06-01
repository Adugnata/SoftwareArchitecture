package com.webshopclient.product;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    private int nrInStock;
    private String locationCode;
}
