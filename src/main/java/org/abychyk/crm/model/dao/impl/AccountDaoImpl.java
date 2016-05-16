package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.domain.Account;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by abychik on 16.05.2016.
 */
public class AccountDaoImpl implements AccountDao {
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<Account> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Account a").list();
    }

    public Account findById(Long id) {
        return null;
    }

    public Account save(Account case_) {
        return null;
    }

    public void delete(Account case_) {

    }
}
