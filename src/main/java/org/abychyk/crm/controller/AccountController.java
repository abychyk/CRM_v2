package org.abychyk.crm.controller;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by abychik on 22.05.2016.
 */
@RequestMapping("/accounts")
@Controller
public class AccountController {
    AccountDao accountDao;
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        List<Account> accountList = accountDao.findAll();
        uiModel.addAttribute("accounts", accountList);
        return "accounts/list";
    }
    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
