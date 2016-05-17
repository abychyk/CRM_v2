package org.abychyk.crm.model.dao;

import org.abychyk.crm.model.domain.Account;

import java.util.List;

/**
 * Created by abychik on 16.05.2016.
 */
public interface AccountDao {
    List<Account> findAll();
    Account findById(Long id);
    List<Account> findAllWithAddress();
    Account findWithParameters(Account account);
    //create and update
    Account save(Account account);
    void delete(Account account);
}
