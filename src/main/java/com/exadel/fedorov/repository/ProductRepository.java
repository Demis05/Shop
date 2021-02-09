package com.exadel.fedorov.repository;

import com.exadel.fedorov.domain.Product;

import java.util.List;

public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {
        products.add(new Product(1L, "Prod1", "product 11", 123, 1, 3));
        products.add(new Product(2L, "Prod2", "product 22", 234, 2, 2));
        products.add(new Product(3L, "Prod3", "product 33", 345, 3, 1));
    }

    public List<Product> getProducts() {
        return products;
    }
}

