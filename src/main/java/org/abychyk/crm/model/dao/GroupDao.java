package org.abychyk.crm.model.dao;

import org.abychyk.crm.model.domain.Group;

import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
public interface GroupDao {
    List<Group> findAll();
    Group findById(Long id);
    //create and update
    Group save(Group group);
    void delete(Group group);
}
