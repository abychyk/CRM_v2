package org.abychyk.crm.controller;

import org.abychyk.crm.model.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by abychik on 09.06.2016.
 */
@Controller
public class IndexController {
    @RequestMapping(value={"/index", "/"})
    public String index() {
        return "index";
    }
}
