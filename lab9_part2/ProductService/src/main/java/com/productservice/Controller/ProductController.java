package com.productservice.Controller;

import com.productservice.model.Product;
import com.productservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    StockService stockService;
    @RequestMapping("/{productNumber}")
    public Product getProduct(@PathVariable("productNumber") String productNumber){
        int productCount = stockService.getProductCount(productNumber);
        return new Product("7", "HP Laptop" + productNumber, productCount);

    }
}
