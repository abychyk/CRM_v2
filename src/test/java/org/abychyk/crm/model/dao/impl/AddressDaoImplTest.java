package org.abychyk.crm.model.dao.impl;

import org.abychyk.crm.model.dao.AddressDao;
import org.abychyk.crm.model.domain.Address;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

/**
 * Created by abychik on 19.05.2016.
 */
@FixMethodOrder(MethodSorters.JVM)
public class AddressDaoImplTest {
    ApplicationContext context = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + "/src/main/resources/app-context-annotation.xml");
    Address address = null;
    List<Address> addressList = null;
    AddressDao addressDao = null;
    @Before
    public void init() {
        addressDao = (AddressDao) context.getBean("addressDao");

        address = new Address();
        address.setBuildingNumber("Test");
        address.setCity("TestCity");
        address.setCountry("TestCountry");
        address.setStreet("TestStreet");
        address.setZip("TestZIP");
    }
    @Test
    public void findAllTest() {
        addressList = addressDao.findAll();
        assertNotNull(addressList);
    }
    @Test
    public void findByIdTest() {
        address = null;
        address = addressDao.findById(1l);
        assertNotNull(address);
    }
    @Test
    public void saveTest() {
        int recordsCount = addressDao.findAll().size();
        addressDao.save(address);
        assertEquals(recordsCount + 1, addressDao.findAll().size());
    }
    @Test
    public void updateTest() {
        address = addressDao.findById(6l);
        address.setStreet("UpdatedStreet");
        addressDao.save(address);
        assertEquals(address.getStreet(), addressDao.findById(6l).getStreet());
    }
    @Test
    public void deleteTest() {
        addressDao.delete(addressDao.findById(6l));
        assertNull(addressDao.findById(6l));
    }
    @After
    public void destroy() {
        addressDao = null;
        address = null;
    }
}
