package com.productcommandservice.service;

import com.productcommandservice.domain.Product;

public interface IProductStockService {
    void updateProduct(Product product);
    void deleteProduct(String productNumber);
}
