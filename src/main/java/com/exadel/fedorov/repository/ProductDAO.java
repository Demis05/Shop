package com.exadel.fedorov.repository;

import com.exadel.fedorov.domain.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public ProductDAO() {
    }

    public ProductDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Product getProductById(long id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    public void update(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
    }

    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    public void delete(long id) {
        Product product = new Product();
        product.setId(id);
        sessionFactory.getCurrentSession().delete(product);
    }

    public List<Product> list() {
        return sessionFactory.getCurrentSession().createCriteria(Product.class).list();
    }
}

