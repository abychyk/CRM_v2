package org.abychyk.crm.controller;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by abychik on 10.06.2016.
 */
@Controller
public class RegistrationController {

    @Autowired
    AccountDao accountDao;

    @ModelAttribute("account")
    public Account construct() {
        return new Account();
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistration() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegistration(@ModelAttribute("account") Account account) {
        accountDao.save(account);
        return "redirect:/register?success=true";
    }
}
