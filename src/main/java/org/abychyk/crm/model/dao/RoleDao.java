package org.abychyk.crm.model.dao;

import org.abychyk.crm.model.domain.Role;

import java.util.List;

/**
 * Created by abychik on 12.06.2016.
 */
public interface RoleDao {
    List<Role> findAll();
    Role findById(Long id);
    //create and update
    Role save(Role role);
    void delete(Role role);
}
