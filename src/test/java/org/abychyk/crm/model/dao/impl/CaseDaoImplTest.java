package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.dao.CaseDao;
import org.abychyk.crm.model.dao.ProductDao;
import org.abychyk.crm.model.domain.Case;
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
public class CaseDaoImplTest {
    ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
    Case aCase = null;
    List<Case> caseList = null;
    CaseDao caseDao = null;
    @Before
    public void setUp() throws Exception {
        caseDao = (CaseDao) context.getBean("caseDao");
        aCase = new Case();
        aCase.setName("Test");
        aCase.setDateOpen(new Date());
        aCase.setDateClose(null);
        aCase.setDescription("TestDescription");
        aCase.setPriority(Case.Priority.HIGH);
        aCase.setStatus(Case.Status.IN_WORK);
        aCase.setReason("TestReason");
        aCase.setType("TestType");
    }

    @After
    public void tearDown() throws Exception {
        caseDao = null;
        aCase = null;
    }

    @Test
    public void testFindAll() throws Exception {
        caseList = caseDao.findAll();
        assertNotNull(caseList);
    }

    @Test
    public void testFindById() throws Exception {
        aCase = null;
        aCase = caseDao.findById(1l);
        assertNotNull(aCase);
    }

    @Test
    public void testSave() throws Exception {
        AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        ProductDao productDao = (ProductDao) context.getBean("productDao");
        int count = caseDao.findAll().size();
        aCase.setAccount(accountDao.findById(4l));
        aCase.setProduct(productDao.findById(1l));
        caseDao.save(aCase);
        assertEquals(count + 1, caseDao.findAll().size());
    }

    @Test
    public void testDelete() throws Exception {
        caseDao.delete(caseDao.findById(3l));
        assertNull(caseDao.findById(3l));
    }
}