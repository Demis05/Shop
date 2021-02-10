package com.exadel.fedorov.repository;

import com.exadel.fedorov.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
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
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
        session.evict(product);
        session.update(product);
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
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Product.class).list();
    }

}

