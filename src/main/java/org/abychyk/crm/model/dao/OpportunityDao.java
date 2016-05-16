package org.abychyk.crm.model.dao;

import org.abychyk.crm.model.domain.Opportunity;

import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
public interface OpportunityDao {
    List<Opportunity> findAll();
    Opportunity findById(Long id);
    //create and update
    Opportunity save(Opportunity opportunity);
    void delete(Opportunity opportunity);
}
