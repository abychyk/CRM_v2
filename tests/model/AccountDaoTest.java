package model;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.domain.Account;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

/**
 * Created by abychyk on 17.05.2016.
 */
public class AccountDaoTest {
    ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
    AccountDao accountDao = null;
    List<Account> accountList = null;

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
}
