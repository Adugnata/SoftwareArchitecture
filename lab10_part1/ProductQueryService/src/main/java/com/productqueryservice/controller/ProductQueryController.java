package com.productqueryservice.controller;


import com.productqueryservice.domain.CustomErrorType;
import com.productqueryservice.domain.ProductStock;
import com.productqueryservice.domain.Products;
import com.productqueryservice.service.ProductQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductQueryController {

    @Autowired
    private ProductQueryService productQueryService;

    @GetMapping("/product_stock/{productNumber}")
    public ResponseEntity<?> getProductStockByNumber(@PathVariable String productNumber) {
        ProductStock product = productQueryService.getProduct(productNumber);
        if (product == null) {
            return new ResponseEntity<>(new CustomErrorType("Product with productNumber= "
                    + productNumber + " was not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/product_stock")
    public ResponseEntity<?> getAllProductStock() {
        Products allProducts = new Products(productQueryService.getProducts());
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
}
