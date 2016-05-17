package org.abychyk;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
public class CRM_Main {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
        AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        List<Account> accountList = accountDao.findAll();
        for (Account acc : accountList) {
            System.out.println(acc.getId());
            System.out.println(acc.getEmail());
        }
    }
}
