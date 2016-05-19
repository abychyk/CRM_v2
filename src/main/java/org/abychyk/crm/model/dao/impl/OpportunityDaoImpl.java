package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.OpportunityDao;
import org.abychyk.crm.model.domain.Opportunity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
@Transactional
@Repository("opportunityDao")
public class OpportunityDaoImpl implements OpportunityDao {
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<Opportunity> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Opportunity op").list();
    }
    @Transactional(readOnly = true)
    public Opportunity findById(Long id) {
        return sessionFactory.getCurrentSession().get(Opportunity.class, id);
    }

    public Opportunity save(Opportunity opportunity) {
        sessionFactory.getCurrentSession().saveOrUpdate(opportunity);
        return opportunity;
    }

    public void delete(Opportunity opportunity) {
        sessionFactory.getCurrentSession().delete(opportunity);
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
