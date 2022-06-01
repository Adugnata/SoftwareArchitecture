package com.webshop.product.controller;

import com.webshop.product.domain.Product;
import com.webshop.product.domain.Products;
import com.webshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productNumber}")
    public ResponseEntity<?> getProductByNumber(@PathVariable String productNumber) {
        Product product = productService.findProductByNumber(productNumber);
        if (product == null) {
            return new ResponseEntity<>(new CustomErrorType("Product with productNumber= "
                    + productNumber + " was not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        Products allProducts = new Products(productService.findAll());
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
}
