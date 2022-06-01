package com.webshop.shopping.domain;

import com.webshop.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartLine {
    private int quantity;
    private Product product;}