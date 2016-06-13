package org.abychyk;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
public class CRM_Main {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
        ApplicationContext context1 = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/web/WEB-INF/spring/security.xml");
        AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        BCryptPasswordEncoder passwordEncoder = (BCryptPasswordEncoder) context1.getBean("encoder");

        List<Account> accountList = accountDao.findAll();
        for (Account acc : accountList) {
            if (acc.getPassword().length() >= 40) {
                acc.setPassword(passwordEncoder.encode(acc.getPassword()));
            }
            accountDao.save(acc);
        }
    }
}
