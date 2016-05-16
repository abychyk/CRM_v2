package org.abychyk.crm.model.dao;

import org.abychyk.crm.model.domain.Product;

import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
public interface ProductDao {
    List<Product> findAll();
    Product findById(Long id);
    //create and update
    Product save(Product product);
    void delete(Product product);
}
