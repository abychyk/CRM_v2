package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.CompanyOwnerDao;
import org.abychyk.crm.model.domain.CompanyOwner;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by abychik on 16.05.2016.
 */
@Transactional
@Repository("companyOwnerDao")
public class CompanyOwnerDaoImpl implements CompanyOwnerDao {
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<CompanyOwner> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from CompanyOwner co").list();
    }
    @Transactional(readOnly = true)
    public CompanyOwner findById(Long id) {
        return sessionFactory.getCurrentSession().get(CompanyOwner.class, id);
    }

    public CompanyOwner save(CompanyOwner companyOwner) {
        sessionFactory.getCurrentSession().saveOrUpdate(companyOwner);
        return companyOwner;
    }

    public void delete(CompanyOwner companyOwner) {
        sessionFactory.getCurrentSession().delete(companyOwner);
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
