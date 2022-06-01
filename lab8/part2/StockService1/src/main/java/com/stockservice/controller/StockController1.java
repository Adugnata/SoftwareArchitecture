package com.stockservice.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Profile("One")
@RequestMapping("/stock")
public class StockController1 {

    @RequestMapping("/{productNumber}" )
    public int getProductCount(@PathVariable("productNumber") String productNumber) {
        HashMap<String, Integer> productCounts = new HashMap<>();
        productCounts.put("1", 10);
        productCounts.put("2", 11);
        productCounts.put("5", 22);
        productCounts.put("3", 33);
        productCounts.put("7", 44);
        return productCounts.getOrDefault(productNumber, 7);
    }
}