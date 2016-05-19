package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.ProductDao;
import org.abychyk.crm.model.domain.Product;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
@Transactional
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Product p").list();
    }
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    public Product save(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
        return product;
    }

    public void delete(Product product) {
        sessionFactory.getCurrentSession().delete(product);
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
