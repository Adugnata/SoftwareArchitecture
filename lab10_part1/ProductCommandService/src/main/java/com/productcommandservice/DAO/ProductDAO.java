package com.productcommandservice.DAO;

import com.productcommandservice.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductDAO extends MongoRepository<Product, String> {
    Product findByProductNumber(String productNumber);
}
