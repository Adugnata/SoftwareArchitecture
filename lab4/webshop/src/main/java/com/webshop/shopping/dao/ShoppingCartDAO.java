package com.webshop.shopping.dao;

import com.webshop.shopping.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartDAO extends MongoRepository<ShoppingCart, String> {

    ShoppingCart findByShoppingCartNumber(String shoppingCartNumber);
}
