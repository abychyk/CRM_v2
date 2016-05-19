package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.OrderDao;
import org.abychyk.crm.model.dao.OrderDetailsDao;
import org.abychyk.crm.model.dao.ProductDao;
import org.abychyk.crm.model.domain.OrderDetails;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by abychik on 19.05.2016.
 */
@FixMethodOrder(MethodSorters.JVM)
public class OrderDetailsDaoImplTest {
    ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
    OrderDetails orderDetails = null;
    OrderDetailsDao orderDetailsDao = null;
    List<OrderDetails> orderDetailsList = null;
    @Before
    public void setUp() throws Exception {
        orderDetailsDao = (OrderDetailsDao) context.getBean("orderDetailsDao");
        orderDetails = new OrderDetails();
        orderDetails.setDiscount(15);
        orderDetails.setQuantity(100l);
        orderDetails.setUnitPrice(new BigDecimal(150));
    }

    @After
    public void tearDown() throws Exception {
        orderDetails = null;
        orderDetailsDao = null;
    }

    @Test
    public void testFindAll() throws Exception {
        orderDetailsList = orderDetailsDao.findAll();
        assertNotNull(orderDetailsList);
    }

    @Test
    public void testFindById() throws Exception {
        assertNotNull(orderDetailsDao.findById(1l));
    }

    @Test
    public void testSave() throws Exception {
        int count = orderDetailsDao.findAll().size();
        ProductDao productDao = (ProductDao) context.getBean("productDao");
        OrderDao orderDao = (OrderDao) context.getBean("orderDao");
        orderDetails.setProduct(productDao.findById(1l));
        orderDetails.setOrder(orderDao.findById(1l));
        orderDetailsDao.save(orderDetails);
        assertEquals(count + 1, orderDetailsDao.findAll().size());
    }

    @Test
    public void testDelete() throws Exception {
        orderDetailsDao.delete(orderDetailsDao.findById(5l));
        assertNull(orderDetailsDao.findById(5l));
    }
}