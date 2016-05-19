package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.CompanyDao;
import org.abychyk.crm.model.dao.OpportunityDao;
import org.abychyk.crm.model.domain.Opportunity;
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
public class OpportunityDaoImplTest {
    ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
    Opportunity opportunity = null;
    OpportunityDao opportunityDao = null;
    List<Opportunity> opportunityList = null;
    @Before
    public void init() {
        opportunityDao = (OpportunityDao) context.getBean("opportunityDao");
        opportunity = new Opportunity();
        opportunity.setProbability(45);
        opportunity.setName("TestOpport");
        opportunity.setCloseDate(new Date(2016, 6, 30));
        opportunity.setAmount(781263l);
    }
    @After
    public void destroy() {
        opportunity = null;
        opportunityDao = null;
    }

    @Test
    public void testFindAll() throws Exception {
        opportunityList = opportunityDao.findAll();
        assertNotNull(opportunityList);
    }

    @Test
    public void testFindById() throws Exception {
        opportunity = null;
        opportunity = opportunityDao.findById(1l);
        assertNotNull(opportunity);
    }

    @Test
    public void testSave() throws Exception {
        CompanyDao companyDao = (CompanyDao) context.getBean("companyDao");
        opportunity.setInitCompany(companyDao.findById(1l));
        opportunity.setRefCompany(companyDao.findById(2l));
        int count = opportunityDao.findAll().size();
        opportunityDao.save(opportunity);
        assertEquals(count + 1, opportunityDao.findAll().size());
    }

    @Test
    public void testDelete() throws Exception {
        opportunityDao.delete(opportunityDao.findById(7l));
        assertNull(opportunityDao.findById(7l));
    }
}