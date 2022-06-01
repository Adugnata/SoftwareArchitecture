package com.stockcommandservice.data;

import com.stockcommandservice.domain.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockDAO extends MongoRepository<Stock, String> {
    Stock findByProductNumber(String productNumber);
}
