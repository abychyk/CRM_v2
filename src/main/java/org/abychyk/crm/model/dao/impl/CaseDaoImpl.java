package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.CaseDao;
import org.abychyk.crm.model.domain.Case;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
@Transactional
@Repository("caseDao")
public class CaseDaoImpl implements CaseDao {
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<Case> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from org.abychyk.crm.model.domain.Case c").list();
    }
    @Transactional(readOnly = true)
    public Case findById(Long id) {
        return sessionFactory.getCurrentSession().get(Case.class, id);
    }

    public Case save(Case aCase) {
        sessionFactory.getCurrentSession().saveOrUpdate(aCase);
        return aCase;
    }

    public void delete(Case aCase) {
        sessionFactory.getCurrentSession().delete(aCase);
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
