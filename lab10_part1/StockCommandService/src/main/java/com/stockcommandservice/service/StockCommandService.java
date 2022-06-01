package com.stockcommandservice.service;


import com.stockcommandservice.data.StockDAO;
import com.stockcommandservice.domain.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockCommandService implements IStockCommand {
    @Autowired
    private StockDAO stockDAO;

    @Override
    public void addStock(Stock stock) {
        stockDAO.save(stock);
    }

    @Override
    public void updateStock(Stock stock) {
        stockDAO.save(stock);
    }

    @Override
    public void deleteStock(String productNumber) {
        Stock stock = findProductByNumber(productNumber);
        stockDAO.delete(stock);
    }

    public Stock findProductByNumber(String productNumber) {
        return stockDAO.findByProductNumber(productNumber);
    }
}
