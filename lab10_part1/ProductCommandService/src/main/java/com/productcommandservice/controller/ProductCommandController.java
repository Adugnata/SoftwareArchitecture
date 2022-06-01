package com.productcommandservice.controller;

import com.productcommandservice.domain.CustomErrorType;
import com.productcommandservice.domain.Product;
import com.productcommandservice.service.ProductCommandService;
import com.productcommandservice.service.ProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductCommandController {
    @Autowired
    private ProductCommandService productCommandService;
    @Autowired
    private ProductStockService productStockService;

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productCommandService.addProduct(product);
        productStockService.updateProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/products")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        Product oldProduct = productCommandService.findProductByNumber(product.getProductNumber());
        if (oldProduct == null) {
            return new ResponseEntity<>(new CustomErrorType("Product with number = "
                    + product.getProductNumber() + " was not found"), HttpStatus.NOT_FOUND);
        }
        productCommandService.updateProduct(product);
        productStockService.updateProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/products/{productNumber}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productNumber) {
        Product toDelete = productCommandService.findProductByNumber(productNumber);
        if (toDelete == null) {
            return new ResponseEntity<>(new CustomErrorType("Product with number = "
                    + productNumber + " was not found"), HttpStatus.NOT_FOUND);
        }
        productCommandService.deleteProduct(productNumber);
        productStockService.deleteProduct(productNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
