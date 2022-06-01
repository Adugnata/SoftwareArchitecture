package com.productcommandservice.service;

import com.productcommandservice.DAO.ProductStockDAO;
import com.productcommandservice.domain.Product;
import com.productcommandservice.domain.ProductStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductStockService implements IProductStockService {
    @Autowired
    ProductStockDAO productStockDAO;

    @Override
    public void updateProduct(Product product) {
        ProductStock productStock = productStockDAO.findByProductNumber(product.getProductNumber());
        if (productStock == null) {
            // create a new ProductStock object with quantity equal to 0
            productStock = new ProductStock(product);
        } else {
            productStock.updateProduct(product);
        }
        productStockDAO.save(productStock);
    }

    @Override
    public void deleteProduct(String productNumber) {
        ProductStock productStock = productStockDAO.findByProductNumber(productNumber);
        if (productStock != null) {
            productStockDAO.delete(productStock);
        }
    }
}
