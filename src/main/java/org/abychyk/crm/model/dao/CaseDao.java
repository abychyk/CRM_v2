package org.abychyk.crm.model.dao;

import org.abychyk.crm.model.domain.Case;

import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
public interface CaseDao {
    List findAll();
    Case findById(Long id);
    //create and update
    Case save(Case aCase);
    void delete(Case aCase);
}
