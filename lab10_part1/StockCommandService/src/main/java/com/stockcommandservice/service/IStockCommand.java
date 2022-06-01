package com.stockcommandservice.service;


import com.stockcommandservice.domain.Stock;

public interface IStockCommand {
    void addStock(Stock stock);
    void updateStock(Stock stock);
    void deleteStock(String productNumber);
}
