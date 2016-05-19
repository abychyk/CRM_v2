package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.OrderDao;
import org.abychyk.crm.model.domain.Order;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by abychik on 16.05.2016.
 */
@Transactional
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Order ord").list();
    }
    @Transactional(readOnly = true)
    public Order findById(Long id) {
        return sessionFactory.getCurrentSession().get(Order.class, id);
    }

    public Order save(Order order) {
        sessionFactory.getCurrentSession().saveOrUpdate(order);
        return order;
    }

    public void delete(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
