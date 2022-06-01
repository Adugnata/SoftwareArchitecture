package com.productcommandservice.service;


import com.productcommandservice.domain.Product;

public interface IProductCommand {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(String productNumber);
}
