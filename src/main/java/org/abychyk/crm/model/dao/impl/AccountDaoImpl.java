package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.domain.Account;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by abychik on 16.05.2016.
 */
@Transactional
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<Account> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Account a").list();
    }

    public Account findById(Long id) {
        return sessionFactory.getCurrentSession().get(Account.class, id);
    }

    public List<Account> findAllWithAddress() {
        return sessionFactory.getCurrentSession().getNamedQuery("Account.findAllWithAddress").list();
    }

    public Account findWithParameters(Account account) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(Account.class);
        c.add(Restrictions.eq("email", account.getEmail()));
        c.add(Restrictions.eq("firstName", account.getFirstName()));
        c.add(Restrictions.eq("lastName", account.getLastName()));
        c.add(Restrictions.eq("phone", account.getPhone()));
        return (Account) c.list().get(0);
    }

    public Account save(Account account) {
        sessionFactory.getCurrentSession().saveOrUpdate(account);
        return account;
    }

    public void delete(Account account) {
        sessionFactory.getCurrentSession().delete(account);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
