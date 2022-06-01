package com.webshop.product.service;

import com.webshop.product.dao.ProductDAO;
import com.webshop.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addProduct(Product product) {
        productDAO.save(product);
    }

    public Product findProductByNumber(String productNumber) {
        return productDAO.findByProductNumber(productNumber);
    }

    public List<Product> findAll() {
        return productDAO.findAll();
    }
}
