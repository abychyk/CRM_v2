package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.dao.EmployeeDao;
import org.abychyk.crm.model.dao.OrderDao;
import org.abychyk.crm.model.domain.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by abychik on 19.05.2016.
 */
@FixMethodOrder(MethodSorters.JVM)
public class OrderDaoImplTest {
    ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
    Order order = null;
    OrderDao orderDao = null;
    List<Order> orderList = null;
    @Before
    public void setUp() throws Exception {
        orderDao = (OrderDao) context.getBean("orderDao");
        order = new Order();
        order.setOrderDate(new Date());
        order.setShipAddress("Test");
        order.setShipCity("Test");
        order.setShipCountry("Test");
        order.setShippedDate(new Date());
        order.setRequiredDate(new Date());
    }

    @After
    public void tearDown() throws Exception {
        order = null;
        orderDao = null;
    }

    @Test
    public void testFindAll() throws Exception {
        orderList = orderDao.findAll();
        assertNotNull(orderList);
    }

    @Test
    public void testFindById() throws Exception {
        order = null;
        order = orderDao.findById(1l);
        assertNotNull(order);
    }

    @Test
    public void testSave() throws Exception {
        int count = orderDao.findAll().size();
        AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        order.setAccount(accountDao.findById(1l));
        /*order.setEmployee(employeeDao.findById(1l));*/
        orderDao.save(order);
        assertEquals(count + 1, orderDao.findAll().size());
    }

    @Test
    public void testDelete() throws Exception {
        orderDao.delete(orderDao.findById(5l));
        assertNull(orderDao.findById(5l));
    }
}