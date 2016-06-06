package org.abychyk.crm.controller;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by abychyk on 22.05.2016.
 */
@Controller
public class LoginController {
    private AccountDao accountDao;
    private Account account;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    //@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("account") Account account) {
        ModelAndView mav = null;
        try {
            boolean isValidAccount = accountDao.isValidAccount(account);
            if (isValidAccount) {
                request.setAttribute("loggedInFirstName", account.getFirstName());
                request.setAttribute("loggedInLastName", account.getLastName());
                mav = new ModelAndView("/");
            } else {
                mav = new ModelAndView("login");
                mav.addObject("account", account);
                request.setAttribute("message", "Invalid credentials!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
