package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.CompanyDao;
import org.abychyk.crm.model.domain.Company;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by abychik on 19.05.2016.
 */
@FixMethodOrder(MethodSorters.JVM)
public class CompanyDaoImplTest {
    ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
    Company company = null;
    CompanyDao companyDao = null;
    List<Company> companyList = null;
    @Before
    public void init() {
        company = new Company();
        company.setPhone("934650235");
        company.setAnnualRevenue(new BigDecimal(125124));
        company.setName("oiaudfhaiuerht");
        company.setCreationDate(new Date());
    }
    @Test
    public void findAllTest() {
        companyDao = (CompanyDao) context.getBean("companyDao");
        companyList = companyDao.findAll();
        assertNotEquals(0, companyList.size());
    }
    @Test
    public void findByIdTest() {
        companyDao = (CompanyDao) context.getBean("companyDao");
        company = companyDao.findById(1l);
        assertNotNull(company);
    }
    @Test
    public void saveTest() {
        companyDao = (CompanyDao) context.getBean("companyDao");
        int recordsCount = companyDao.findAll().size();
        companyDao.save(company);
        assertEquals(recordsCount + 1, companyDao.findAll().size());
    }
    @Test
    public void updateTest() {
        companyDao = (CompanyDao) context.getBean("companyDao");
        company = companyDao.findById(6l);
        company.setName("UpdatedTestName");
        companyDao.save(company);
        assertEquals(company.getName(), companyDao.findById(company.getId()).getName());
        company.setName("oiaudfhaiuerht");
        companyDao.save(company);
    }
    @Test
    public void deleteTest() {
        companyDao = (CompanyDao) context.getBean("companyDao");
        companyDao.delete(companyDao.findById(6l));
        company = companyDao.findById(6l);
        assertNull(company);
    }
    @After
    public void destroy() {
        company = null;
    }
}
