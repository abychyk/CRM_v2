package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.domain.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by abychyk on 17.05.2016.
 */
@FixMethodOrder(MethodSorters.JVM)
public class AccountDaoImplTest {
    ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
    AccountDao accountDao = null;
    List<Account> accountList = null;
    Account account = null;

    @Before
    public void init() {
        account = new Account();
        account.setEmail("oshidfsiohr");
        account.setPassword("ghdfshf");
        account.setFirstName("TestSaveAccFirstName");
        account.setLastName("TestSaveAccLastName");
        account.setBirthDate(new Date());
        account.setPhone("34564234");
    }

    @Test
    public void findAllTest() {
        accountDao = (AccountDao) context.getBean("accountDao");
        accountList = accountDao.findAll();
        assertEquals(5, accountList.size());
    }

    @Test
    public void findAllWithAddressTest() {
        accountDao = (AccountDao) context.getBean("accountDao");
        accountList = accountDao.findAllWithAddress();
        assertEquals(2, accountList.get(0).getAddress().size());
    }

    @Test
    public void createAccountTest() {
        accountDao = (AccountDao) context.getBean("accountDao");
        int recordCount = accountDao.findAll().size();

        accountDao.save(account);

        assertEquals(recordCount + 1, accountDao.findAll().size());
    }

    @Test
    public void findWithParametersTest() {
        accountDao = (AccountDao) context.getBean("accountDao");
        account = accountDao.findWithParameters(account);
        assertNotNull(account.getId());
    }

    @Test
    public void updateAccountTest() {
        accountDao = (AccountDao) context.getBean("accountDao");

        account = accountDao.findWithParameters(account);
        account.setFirstName("UpdatedTestFirstName");
        accountDao.save(account);

        assertEquals(account.getFirstName(), accountDao.findById(account.getId()).getFirstName());

        account.setFirstName("TestSaveAccFirstName");
        accountDao.save(account);
    }

    @Test
    public void deleteAccountTest() {
        accountDao = (AccountDao) context.getBean("accountDao");
        account = accountDao.findWithParameters(account);
        accountDao.delete(account);
        assertNull(accountDao.findById(account.getId()));
    }

    @After
    public void destroy() {
        account = null;
    }
}
