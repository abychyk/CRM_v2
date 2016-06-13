package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.CompanyDao;
import org.abychyk.crm.model.domain.Account;
import org.abychyk.crm.model.domain.Company;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
@Transactional
@Repository("companyDao")
public class CompanyDaoImpl implements CompanyDao {
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<Company> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Company c").list();
    }
    @Transactional(readOnly = true)
    public Company findById(Long id) {
        return sessionFactory.getCurrentSession().get(Company.class, id);
    }

    public Company save(Company company) {
        sessionFactory.getCurrentSession().saveOrUpdate(company);
        return company;
    }

    public void delete(Company company) {
        sessionFactory.getCurrentSession().delete(company);
    }

    public Company findByOwner(Account account) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Company c where c.account.email = :email");
        query.setString("email", account.getEmail());
        List<Company> companyList = query.list();
        if (companyList.size() == 0)
            return null;
        return (Company) query.list().get(0);
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
