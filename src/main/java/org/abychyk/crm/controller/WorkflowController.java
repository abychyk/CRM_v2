package org.abychyk.crm.controller;

import org.abychyk.crm.model.dao.AccountDao;
import org.abychyk.crm.model.dao.CompanyDao;
import org.abychyk.crm.model.dao.ProductDao;
import org.abychyk.crm.model.domain.Account;
import org.abychyk.crm.model.domain.Company;
import org.abychyk.crm.model.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by abychik on 12.06.2016.
 */
//@Controller
public class WorkflowController {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private ProductDao productDao;

    @ModelAttribute("account")
    public Account initAccount() {
        return new Account();
    }

    @ModelAttribute("product")
    public Product initProduct() {
        return new Product();
    }

    @ModelAttribute("companies")
    public Company initCompany() {
        return new Company();
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showProfile(Model model, Principal principal) {
        String name = principal.getName();
        model.addAttribute("user", accountDao.findByEmailWithDetails(name));
        return "userProfile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String doEdit(@ModelAttribute("account") Account account, Principal principal) {
        Account tmpAccount = new Account();
        tmpAccount = accountDao.findByEmailWithDetails(principal.getName());
        /*tmpAccount.setBirthDate(account.getBirthDate());*/
        tmpAccount.setPassword(account.getPassword());
        tmpAccount.setFirstName(account.getFirstName());
        tmpAccount.setLastName(account.getLastName());
        tmpAccount.setPhone(account.getPhone());
        accountDao.save(tmpAccount);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public String showCompany(Model model, Principal principal) {
        Account account = accountDao.findByEmailWithDetails(principal.getName());
        model.addAttribute("company", companyDao.findByOwner(account));
        return "company";
    }

    @RequestMapping(value = "/company/{id}/products/", method = RequestMethod.GET)
    public String showProducts(Model model, Principal principal, @PathVariable long id) {
        model.addAttribute("products", productDao.findByCompanyId(id));
        return "products";
    }
    @RequestMapping(value = "/company/{id}/products/", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product")Product product, @PathVariable long id) {
        product.setId(null);
        product.setCompany(companyDao.findById(id));
        productDao.save(product);
        return "products";
    }

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public String showBuy(Model model) {
        model.addAttribute("products", productDao.findAll());
        return "buy";
    }
    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public String showBuyProduct(Model model, @PathVariable long id) {
        Product product = productDao.findById(id);
        model.addAttribute("product", product);
        return "redirect:/buy/{id}";
    }
}
