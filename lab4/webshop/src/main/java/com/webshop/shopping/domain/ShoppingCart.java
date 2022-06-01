package com.webshop.shopping.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    @Id
    String shoppingCartNumber;
    List<CartLine> cartLines;

    public ShoppingCart(String shoppingCartNumber) {
        this.shoppingCartNumber = shoppingCartNumber;
        this.cartLines = new ArrayList<>();
    }

    public void addToCart(CartLine cartLine) {
        cartLines.add(cartLine);
    }

    public void removeFromCart(CartLine cartLine) {
        cartLines.remove(cartLine);
    }

    public void changeQuantity(CartLine cartLine, int quantity) {
        removeFromCart(cartLine);
        cartLine.setQuantity(quantity);
        addToCart(cartLine);
    }

    public void checkout() {

    }
}