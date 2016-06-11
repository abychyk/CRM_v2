package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.RoleDao;
import org.abychyk.crm.model.domain.Role;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by abychik on 12.06.2016.
 */
@Transactional
@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Role r").list();
    }
    @Transactional(readOnly = true)
    public Role findById(Long id) {
        return sessionFactory.getCurrentSession().get(Role.class, id);
    }

    public Role save(Role role) {
        sessionFactory.getCurrentSession().saveOrUpdate(role);
        return role;
    }

    public void delete(Role role) {
        sessionFactory.getCurrentSession().delete(role);
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
