package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.CompanyDao;
import org.abychyk.crm.model.dao.ProductDao;
import org.abychyk.crm.model.domain.Product;
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
public class ProductDaoImplTest {
    ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
    ProductDao productDao = null;
    Product product = null;
    List<Product> productList = null;
    @Before
    public void setUp() throws Exception {
        productDao = (ProductDao) context.getBean("productDao");
        product = new Product();
        product.setName("TestProduct");
        product.setDefaultPrice(new BigDecimal(14));
        product.setProductCode("97862345");
    }

    @After
    public void tearDown() throws Exception {
        product = null;
        productDao = null;
    }

    @Test
    public void testFindAll() throws Exception {
        productList = productDao.findAll();
        assertNotNull(productList);
    }

    @Test
    public void testFindById() throws Exception {
        assertNotNull(productDao.findById(1l));
    }

    @Test
    public void testSave() throws Exception {
        int count = productDao.findAll().size();
        CompanyDao companyDao = (CompanyDao) context.getBean("companyDao");
        product.setCompany(companyDao.findById(1l));
        productDao.save(product);
        assertEquals(count + 1, productDao.findAll().size());
    }

    @Test
    public void testDelete() throws Exception {
        productDao.delete(productDao.findById(6l));
        assertNull(productDao.findById(6l));
    }
}