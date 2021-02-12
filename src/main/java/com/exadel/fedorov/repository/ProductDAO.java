package com.exadel.fedorov.repository;

import com.exadel.fedorov.domain.Brand;
import com.exadel.fedorov.domain.Product;
import org.hibernate.Session;
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
        Session session = sessionFactory.getCurrentSession();
        Product product = session.find(Product.class, id);
        session.evict(product);
        return product;
    }

    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        String brandName = product.getBrand().getName();
        List<Brand> brands = sessionFactory.getCurrentSession().createCriteria(Brand.class).list();
        for (Brand b : brands) {
            if (b.getName().equals(brandName)) {
                product.getBrand().setId(b.getId());
                break;
            }
        }
        session.evict(product);
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

