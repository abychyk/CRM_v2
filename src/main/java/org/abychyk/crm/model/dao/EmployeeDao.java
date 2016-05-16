package org.abychyk.crm.model.dao;

import org.abychyk.crm.model.domain.Employee;

import java.util.List;

/**
 * Created by abychik on 16.05.2016.
 */
public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(Long id);
    //create and update
    Employee save(Employee employee);
    void delete(Employee employee);
}
