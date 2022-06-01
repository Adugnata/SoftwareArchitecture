package com.webshopclient.shopping;

import com.webshopclient.product.Product;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CartLine {
    private int quantity;
    private Product product;
}
