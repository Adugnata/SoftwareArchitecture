package com.webshop.product.dao;

import com.webshop.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductDAO extends MongoRepository<Product, String> {

    Product findByProductNumber(String productNumber);
}

