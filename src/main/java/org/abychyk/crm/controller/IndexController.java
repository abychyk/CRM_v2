package org.abychyk.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
