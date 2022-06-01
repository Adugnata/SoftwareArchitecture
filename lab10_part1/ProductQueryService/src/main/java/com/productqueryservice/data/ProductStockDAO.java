package com.productqueryservice.data;


import com.productqueryservice.domain.ProductStock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductStockDAO extends MongoRepository<ProductStock, String> {
    ProductStock findByProductNumber(String productNumber);
}
