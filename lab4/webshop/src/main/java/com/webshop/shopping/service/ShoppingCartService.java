package com.webshop.shopping.service;

import com.webshop.shopping.dao.ShoppingCartDAO;
import com.webshop.shopping.domain.CartLine;
import com.webshop.shopping.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {


    private final ShoppingCartDAO shoppingCartDAO;
    @Autowired
    public ShoppingCartService(ShoppingCartDAO shoppingCartDAO) {
        this.shoppingCartDAO = shoppingCartDAO;
    }

    public ShoppingCart findShoppingCartByNumber(String shoppingCartNumber) {
        return shoppingCartDAO.findByShoppingCartNumber(shoppingCartNumber);
    }

    public ShoppingCart addToShoppingCart(String shoppingCartNumber, CartLine cartLine) {
        ShoppingCart cart = findShoppingCartByNumber(shoppingCartNumber);
        if (cart == null) {
            cart = new ShoppingCart(shoppingCartNumber);
        }
        cart.addToCart(cartLine);

        return shoppingCartDAO.save(cart);
    }
}
