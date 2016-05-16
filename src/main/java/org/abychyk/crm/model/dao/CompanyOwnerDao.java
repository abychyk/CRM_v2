package org.abychyk.crm.model.dao;

import org.abychyk.crm.model.domain.CompanyOwner;

import java.util.List;

/**
 * Created by abychik on 16.05.2016.
 */
public interface CompanyOwnerDao {
    List<CompanyOwner> findAll();
    CompanyOwner findById(Long id);
    //create and update
    CompanyOwner save(CompanyOwner companyOwner);
    void delete(CompanyOwner companyOwner);
}
