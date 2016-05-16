package org.abychyk.crm.model.dao;

import org.abychyk.crm.model.domain.Company;

import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
public interface CompanyDao {
    List<Company> findAll();
    Company findById(Long id);
    //create and update
    Company save(Company company);
    void delete(Company company);
}
