package com.productcommandservice.service;

import com.productcommandservice.DAO.ProductDAO;
import com.productcommandservice.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;

@Service
public class ProductCommandService implements IProductCommand {
    @Autowired
    ProductDAO productDao;

    @Override
    public void addProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void deleteProduct(String productNumber) {
        Product product = findProductByNumber(productNumber);
        productDao.delete(product);
    }

    public Product findProductByNumber(String productNumber) {
        return productDao.findByProductNumber(productNumber);
    }

}
