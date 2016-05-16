package org.abychyk.crm.model.dao;

import org.abychyk.crm.model.domain.Address;

import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
public interface AddressDao {
    List<Address> findAll();
    Address findById(Long id);
    //create and update
    Address save(Address address);
    void delete(Address address);
}
