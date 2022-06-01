package com.stockcommandservice.service;


import com.stockcommandservice.domain.Stock;

public interface IProductStockService {
    void upsertStock(Stock stock);
    void deleteStock(String productNumber);
}
