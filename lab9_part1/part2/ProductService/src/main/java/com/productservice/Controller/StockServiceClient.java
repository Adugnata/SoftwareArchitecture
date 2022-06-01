package com.productservice.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="StockService")
public interface StockServiceClient {
    @GetMapping("/stock/{productNumber}")
    int getProductCount(@PathVariable("productNumber") String ProductNumber);
}
