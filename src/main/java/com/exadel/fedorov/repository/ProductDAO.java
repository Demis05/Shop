package com.exadel.fedorov.repository;

import com.exadel.fedorov.domain.Product;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
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

    public Product getProductById(long id) {//TODO
        String hql = "from products where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        @SuppressWarnings("unchecked")
        List<Product> listUser = (List<Product>) query.getResultList();
        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }
        return null;
    }

    public void update(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    public void delete(long id) {
        Product product = new Product();
        product.setId(id);
        sessionFactory.getCurrentSession().delete(product);
    }

    public List<Product> list() {//TODO
        @SuppressWarnings("unchecked")
        List<Product> listUser = (List<Product>) sessionFactory.getCurrentSession()
                .createCriteria(Product.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listUser;
    }

}

