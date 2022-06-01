package com.productservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockServiceClient stockServiceClient;

    @HystrixCommand(fallbackMethod = "getFallbackProductCount")
    public int getProductCount(String productNumber) {
        return stockServiceClient.getProductCount(productNumber);
    }

    public int getFallbackProductCount(String productNumber) {
        return 0;
    }
}
