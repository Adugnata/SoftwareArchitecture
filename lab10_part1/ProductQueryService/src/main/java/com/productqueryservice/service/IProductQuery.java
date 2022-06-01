package com.productqueryservice.service;



import com.productqueryservice.domain.ProductStock;

import java.util.List;

public interface IProductQuery {
    List<ProductStock> getProducts();
    ProductStock getProduct(String productNumber);
}
