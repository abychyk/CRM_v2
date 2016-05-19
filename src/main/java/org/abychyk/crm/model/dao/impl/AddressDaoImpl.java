package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.AddressDao;
import org.abychyk.crm.model.domain.Address;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by abychik on 15.05.2016.
 */
@Transactional
@Repository("addressDao")
public class AddressDaoImpl implements AddressDao {
    private SessionFactory sessionFactory;
    @Transactional(readOnly = true)
    public List<Address> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Address ad").list();
    }
    @Transactional(readOnly = true)
    public Address findById(Long id) {
        return sessionFactory.getCurrentSession().get(Address.class, id);
    }

    public Address save(Address address) {
        sessionFactory.getCurrentSession().saveOrUpdate(address);
        return address;
    }

    public void delete(Address address) {
        sessionFactory.getCurrentSession().delete(address);
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
