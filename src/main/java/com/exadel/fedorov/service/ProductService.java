package com.exadel.fedorov.service;

import com.exadel.fedorov.domain.Product;
import com.exadel.fedorov.dto.ProductDto;
import com.exadel.fedorov.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public List<Product> getProducts() {
        return productDAO.list();
    }

    public Product getProductById(Long id) {
        return productDAO.getProductById(id);
    }

    public void update(Product product) {
        productDAO.update(product);
    }

    public void save(Product product) {
        productDAO.save(product);
    }

    public void delete(Long id) {
        productDAO.delete(id);
    }
}
