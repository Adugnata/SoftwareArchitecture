package com.productqueryservice.service;


import com.productqueryservice.data.ProductStockDAO;
import com.productqueryservice.domain.ProductStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQueryService implements IProductQuery {

    @Autowired
    private ProductStockDAO productStockDAO;

    @Override
    public List<ProductStock> getProducts() {
        return productStockDAO.findAll();
    }

    @Override
    public ProductStock getProduct(String productNumber) {
        return productStockDAO.findByProductNumber(productNumber);
    }
}
