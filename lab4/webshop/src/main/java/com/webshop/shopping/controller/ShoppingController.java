package com.webshop.shopping.controller;

import com.webshop.product.controller.CustomErrorType;
import com.webshop.shopping.domain.CartLine;
import com.webshop.shopping.domain.ShoppingCart;
import com.webshop.shopping.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingController {

    private final ShoppingCartService shoppingCartService;
    @Autowired
    public ShoppingController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/cart/{cartNumber}")
    public ResponseEntity<?> getShoppingCartByNumber(@PathVariable String cartNumber) {
        ShoppingCart cart = shoppingCartService.findShoppingCartByNumber(cartNumber);
        if (cart == null) {
            return new ResponseEntity<>(new CustomErrorType("Shopping Cart with number = "
                    + cartNumber + " was not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping("/cart/{cartNumber}")
    public ResponseEntity<?> addProductToCart(@PathVariable String cartNumber, @RequestBody CartLine cartLine) {
        ShoppingCart cart = shoppingCartService.addToShoppingCart(cartNumber, cartLine);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }
}