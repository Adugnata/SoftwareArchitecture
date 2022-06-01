package com.productqueryservice.domain;

import java.util.List;

public class Products {
    private List<ProductStock> products;

    public Products(List<ProductStock> products) {
        this.products = products;
    }

    public Products() {
    }

    public List<ProductStock> getProducts() {
        return products;
    }

    public void setProducts(List<ProductStock> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Products{" +
                "products=" + products +
                '}';
    }
}
