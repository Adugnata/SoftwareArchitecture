package com.productservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "StockService")
public interface StockServiceClient {
    @RequestMapping("/stock/{productNumber}" )
    int getProductCount(@PathVariable("productNumber") String productNumber);
}
