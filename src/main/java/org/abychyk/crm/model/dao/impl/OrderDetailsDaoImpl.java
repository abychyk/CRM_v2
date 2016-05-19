package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.OrderDetailsDao;
import org.abychyk.crm.model.domain.OrderDetails;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by abychik on 16.05.2016.
 */
@Transactional
@Repository("orderDetailsDao")
public class OrderDetailsDaoImpl implements OrderDetailsDao {
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<OrderDetails> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from OrderDetails ordDet").list();
    }
    @Transactional(readOnly = true)
    public OrderDetails findById(Long id) {
        return sessionFactory.getCurrentSession().get(OrderDetails.class, id);
    }

    public OrderDetails save(OrderDetails orderDetails) {
        sessionFactory.getCurrentSession().saveOrUpdate(orderDetails);
        return orderDetails;
    }

    public void delete(OrderDetails orderDetails) {
        sessionFactory.getCurrentSession().delete(orderDetails);
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
