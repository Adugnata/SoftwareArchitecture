package com.productservice.Controller;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="stock-service")
public interface StockServiceClient {
    @GetMapping("/product_count/{productNumber}")
    int getProductCount(@PathVariable("productNumber") String ProductNumbver);
}
