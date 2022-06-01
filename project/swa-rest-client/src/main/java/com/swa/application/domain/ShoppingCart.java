package com.swa.application.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShoppingCart {
    private String shoppingCartNumber;
    private List<CartLine> cartLines;
}
