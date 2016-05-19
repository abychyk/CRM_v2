package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.EmployeeDao;
import org.abychyk.crm.model.domain.Employee;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by abychik on 16.05.2016.
 */
@Transactional
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Employee e").list();
    }
    @Transactional(readOnly = true)
    public Employee findById(Long id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    public Employee save(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
        return employee;
    }

    public void delete(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
