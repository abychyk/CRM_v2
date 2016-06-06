package org.abychyk.crm.controller;

import org.abychyk.crm.model.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by abychik on 06.06.2016.
 */
@Controller
@RequestMapping("/user/")
public class WorkflowController {
    @Autowired
    AccountDao accountDao;

    @RequestMapping(value = "/{id}/company", method = RequestMethod.GET)
    public String createCompany(@PathVariable("id") long id, HttpServletRequest request) {
        return "company";
    }
}
