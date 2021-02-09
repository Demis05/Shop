package com.exadel.fedorov.service;

import com.exadel.fedorov.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exadel.fedorov.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.getProducts();
    }
}
