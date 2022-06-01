package com.webshopclient.shopping;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    String shoppingCartNumber;
    List<CartLine> cartLines;
}
