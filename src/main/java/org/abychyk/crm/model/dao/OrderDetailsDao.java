package org.abychyk.crm.model.dao;

import org.abychyk.crm.model.domain.OrderDetails;

import java.util.List;

/**
 * Created by abychik on 16.05.2016.
 */
public interface OrderDetailsDao {
    List<OrderDetails> findAll();
    OrderDetails findById(Long id);
    //create and update
    OrderDetails save(OrderDetails orderDetails);
    void delete(OrderDetails orderDetails);
}
