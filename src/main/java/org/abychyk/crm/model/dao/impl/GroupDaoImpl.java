package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.GroupDao;
import org.abychyk.crm.model.domain.Group;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
@Transactional
@Repository("groupDao")
public class GroupDaoImpl implements GroupDao {
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<Group> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Group g").list();
    }
    @Transactional(readOnly = true)
    public Group findById(Long id) {
        return sessionFactory.getCurrentSession().get(Group.class, id);
    }

    public Group save(Group group) {
        sessionFactory.getCurrentSession().saveOrUpdate(group);
        return group;
    }

    public void delete(Group group) {
        sessionFactory.getCurrentSession().delete(group);
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
