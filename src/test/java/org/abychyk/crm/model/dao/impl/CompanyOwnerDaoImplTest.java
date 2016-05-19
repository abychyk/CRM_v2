package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.dao.CompanyDao;
import org.abychyk.crm.model.dao.CompanyOwnerDao;
import org.abychyk.crm.model.domain.CompanyOwner;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by abychik on 19.05.2016.
 */
@FixMethodOrder(MethodSorters.JVM)
public class CompanyOwnerDaoImplTest {
    ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
    private CompanyOwner companyOwner = null;
    private CompanyOwnerDao companyOwnerDao = null;
    private List<CompanyOwner> companyOwnerList = null;
    @Before
    public void setUp() throws Exception {
        companyOwnerDao = (CompanyOwnerDao) context.getBean("companyOwnerDao");
        companyOwner = new CompanyOwner();
    }

    @After
    public void tearDown() throws Exception {
        companyOwner = null;
        companyOwnerDao = null;
    }

    @Test
    public void testFindAll() throws Exception {
        companyOwnerList = companyOwnerDao.findAll();
        assertNotNull(companyOwnerList);
    }

    @Test
    public void testFindById() throws Exception {
        companyOwner = null;
        companyOwner = companyOwnerDao.findById(1l);
        assertNotNull(companyOwner);
    }

    @Test
    public void testSave() throws Exception {
        int count = companyOwnerDao.findAll().size();
        AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        CompanyDao companyDao = (CompanyDao) context.getBean("companyDao");
        companyOwner.setAccount(accountDao.findById(4l));
        companyOwner.setCompany(companyDao.findById(4l));
        companyOwnerDao.save(companyOwner);
        assertEquals(count + 1, companyOwnerDao.findAll().size());
    }

    @Test
    public void testDelete() throws Exception {
        companyOwnerDao.delete(companyOwnerDao.findById(4l));
        assertNull(companyOwnerDao.findById(4l));
    }
}