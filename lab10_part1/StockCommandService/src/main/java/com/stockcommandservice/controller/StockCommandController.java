package com.stockcommandservice.controller;


import com.stockcommandservice.domain.CustomErrorType;
import com.stockcommandservice.domain.Stock;
import com.stockcommandservice.service.ProductStockService;
import com.stockcommandservice.service.StockCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StockCommandController {
    @Autowired
    private StockCommandService stockcommandService;
    @Autowired
    private ProductStockService productStockService;

    @PostMapping("/stock")
    public ResponseEntity<?> addProduct(@RequestBody Stock stock) {
        stockcommandService.addStock(stock);
        productStockService.upsertStock(stock);
        return new ResponseEntity<>(stock, HttpStatus.CREATED);
    }

    @PutMapping("/stock")
    public ResponseEntity<?> updateProduct(@RequestBody Stock stock) {
        Stock oldStock = stockcommandService.findProductByNumber(stock.getProductNumber());
        if (oldStock == null) {
            return new ResponseEntity<>(new CustomErrorType("Stock with number = "
                    + stock.getProductNumber() + " was not found"), HttpStatus.NOT_FOUND);
        }
        stockcommandService.updateStock(stock);
        productStockService.upsertStock(stock);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @DeleteMapping("/stock/{productNumber}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productNumber) {
        Stock toDelete = stockcommandService.findProductByNumber(productNumber);
        if (toDelete == null) {
            return new ResponseEntity<>(new CustomErrorType("Stock with number = "
                    + productNumber + " was not found"), HttpStatus.NOT_FOUND);
        }
        stockcommandService.deleteStock(productNumber);
        productStockService.deleteStock(productNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
