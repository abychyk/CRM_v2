package org.abychyk.crm.model.dao;

import org.abychyk.crm.model.domain.Order;

import java.util.List;

/**
 * Created by abychik on 16.05.2016.
 */
public interface OrderDao {
    List<Order> findAll();
    Order findById(Long id);
    //create and update
    Order save(Order order);
    void delete(Order order);
}
