package com.stockcommandservice.data;


import com.stockcommandservice.domain.ProductStock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductStockDAO extends MongoRepository<ProductStock, String> {
    ProductStock findByProductNumber(String productNumber);
}
