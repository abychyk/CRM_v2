package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.CompanyDao;
import org.abychyk.crm.model.dao.GroupDao;
import org.abychyk.crm.model.domain.Company;
import org.abychyk.crm.model.domain.Group;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by abychik on 19.05.2016.
 */
@FixMethodOrder(MethodSorters.JVM)
public class GroupDaoImplTest {

    ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
    Group group = null;
    List<Group> groupList = null;
    GroupDao groupDao = null;
    @Before
    public void setUp() throws Exception {
        groupDao = (GroupDao) context.getBean("groupDao");
        group = new Group();
        group.setName("TestGroup");
    }

    @After
    public void tearDown() throws Exception {
        group = null;
        groupDao = null;
    }

    @Test
    public void testFindAll() throws Exception {
        groupList = groupDao.findAll();
        assertNotNull(groupList);
    }

    @Test
    public void testFindById() throws Exception {
        group = null;
        group = groupDao.findById(1l);
        assertNotNull(group);
    }

    @Test
    public void testSave() throws Exception {
        int count = groupDao.findAll().size();
        groupDao.save(group);
        assertEquals(count + 1, groupDao.findAll().size());
    }

    @Test
    public void testUpdate() throws Exception {
        CompanyDao companyDao = (CompanyDao) context.getBean("companyDao");
        group = groupDao.findById(5l);
        group.setCompanies(new HashSet<Company>(companyDao.findAll()));
        groupDao.save(group);
        group = groupDao.findById(5l);
        assertNotNull(group.getCompanies());
        group.setCompanies(null);
        groupDao.save(group);
    }

    @Test
    public void testDelete() throws Exception {
        groupDao.delete(groupDao.findById(5l));
    }
}