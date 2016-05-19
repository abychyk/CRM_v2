package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.dao.CompanyDao;
import org.abychyk.crm.model.dao.EmployeeDao;
import org.abychyk.crm.model.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by abychik on 19.05.2016.
 */
@FixMethodOrder(MethodSorters.JVM)
public class EmployeeDaoImplTest {
    ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
    Employee employee = null;
    EmployeeDao employeeDao = null;
    List<Employee> employeeList = null;
    @Before
    public void init() {
        employeeDao = (EmployeeDao) context.getBean("employeeDao");
        employee = new Employee();
        employee.setSalary(new BigDecimal(1234));
        employee.setHireDate(new Date());
        employee.setPosition("TestPos");
    }

    @After
    public void destroy() {
        employeeDao = null;
        employee = null;
    }

    @Test
    public void testFindAll() throws Exception {
        employeeList = employeeDao.findAll();
        assertNotNull(employeeList);
    }

    @Test
    public void testFindById() throws Exception {
        employee = null;
        employee = employeeDao.findById(1l);
        assertNotNull(employee);
    }

    @Test
    public void testSave() throws Exception {
        int count = employeeDao.findAll().size();
        AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        CompanyDao companyDao = (CompanyDao) context.getBean("companyDao");
        employee.setAccount(accountDao.findById(5l));
        employee.setCompany(companyDao.findById(5l));
        employeeDao.save(employee);
        assertEquals(count + 1, employeeDao.findAll().size());
    }

    @Test
    public void testDelete() throws Exception {
        employeeDao.delete(employeeDao.findById(5l));
        assertNull(employeeDao.findById(5l));
    }
}