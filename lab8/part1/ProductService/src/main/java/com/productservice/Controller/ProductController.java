package com.productservice.Controller;

import com.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    StockServiceClient stockServiceClient;
    @GetMapping("/{productNumber}")
    public Product getProduct(@PathVariable("productNumber") String productNumber){
        int productCount = stockServiceClient.getProductCount(productNumber);
        return new Product("7", "HP Laptop" + productNumber, productCount);

    }
}
