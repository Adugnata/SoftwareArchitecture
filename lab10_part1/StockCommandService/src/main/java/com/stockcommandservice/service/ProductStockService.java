package com.stockcommandservice.service;


import com.stockcommandservice.data.ProductStockDAO;
import com.stockcommandservice.domain.ProductStock;
import com.stockcommandservice.domain.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductStockService implements IProductStockService {
    @Autowired
    ProductStockDAO productStockDAO;

    @Override
    public void upsertStock(Stock stock) {
        ProductStock productStock = productStockDAO.findByProductNumber(stock.getProductNumber());
        if (productStock == null) {
            // create a new ProductStock object with quantity equal to 0
            productStock = new ProductStock(stock);
        } else {
            productStock.updateStock(stock);
        }
        productStockDAO.save(productStock);
    }

    @Override
    public void deleteStock(String productNumber) {
        ProductStock productStock = productStockDAO.findByProductNumber(productNumber);
        if (productStock != null) {
            productStock.setNumberInStock(0);
            productStockDAO.save(productStock);
        }
    }
}
