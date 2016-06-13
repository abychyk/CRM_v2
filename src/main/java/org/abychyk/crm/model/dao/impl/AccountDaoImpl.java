package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.domain.Account;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Transactional(readOnly = true)
    public List<Account> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Account a").list();
    }

    @Transactional(readOnly = true)
    public Account findById(Long id) {
        return sessionFactory.getCurrentSession().get(Account.class, id);
    }

    @Transactional(readOnly = true)
    public List<Account> findAllWithAddress() {
        return sessionFactory.getCurrentSession().getNamedQuery("Account.findAllWithAddress").list();
    }

    @Transactional(readOnly = true)
    public Account findWithParameters(Account account) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(Account.class);
        c.add(Restrictions.eq("email", account.getEmail()));
        c.add(Restrictions.eq("firstName", account.getFirstName()));
        c.add(Restrictions.eq("lastName", account.getLastName()));
        c.add(Restrictions.eq("phone", account.getPhone()));
        return (Account) c.list().get(0);
    }

    public Account save(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        sessionFactory.getCurrentSession().saveOrUpdate(account);
        return account;
    }

    public boolean isValidAccount(Account account) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Account a where a.email = :email and a.password = :password");
        query.setString("email", account.getEmail());
        query.setString("password", account.getPassword());
        Account accountDB = (Account) query.list().get(0);
        if (account == null)
            return false;
        else
            return true;
    }

    public void delete(Account account) {
        sessionFactory.getCurrentSession().delete(account);
    }
    @Transactional(readOnly = true)
    public Account findByEmailWithDetails(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Account a where a.email = :email");
        query.setString("email", email);
        return (Account) query.list().get(0);
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    /*@Resource(name = "encoder")
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }*/


}
