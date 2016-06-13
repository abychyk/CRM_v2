package org.abychyk.crm.controller;

import org.abychyk.crm.model.dao.*;
import org.abychyk.crm.model.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by abychik on 13.06.2016.
 */
@Controller
public class WorkflowControllerV2 {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @ModelAttribute("company")
    private Company initCompany() {
        return new Company();
    }

    @ModelAttribute("account")
    private Account initAccountAdmin() {
        return new Account();
    }

    @ModelAttribute("product")
    private Product initProduct() {
        return new Product();
    }

    @ModelAttribute("order")
    private Order initOrder() {
        return new Order();
    }

    @ModelAttribute("orderDetails")
    private OrderDetails initOrderDetails() {
        return new OrderDetails();
    }

    @ModelAttribute("address")
    private Address initAddress() {
        return new Address();
    }

    @RequestMapping(value = "/registerAdmin", method = RequestMethod.GET)
    public String regAdmin() {
        return "registerAdmin";
    }

    @RequestMapping(value = "/registerAdmin", method = RequestMethod.POST)
    public String doRegAdmin(@ModelAttribute("account") Account account) {
        long idAdmin = 2;
        account.getRoleSet().add(roleDao.findById(idAdmin));
        accountDao.save(account);
        return "redirect:/registerAdmin?success=true";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showProfile(Model model, Principal principal) {
        String name = principal.getName();
        model.addAttribute("user", accountDao.findByEmailWithDetails(name));
        return "userProfile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String doEdit(@ModelAttribute("account") Account account, Principal principal) {
        Account tmpAccount = accountDao.findByEmailWithDetails(principal.getName());
        tmpAccount.setBirthDate(account.getBirthDate());
        tmpAccount.setPassword(account.getPassword());
        tmpAccount.setFirstName(account.getFirstName());
        tmpAccount.setLastName(account.getLastName());
        tmpAccount.setPhone(account.getPhone());
        accountDao.save(tmpAccount);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/addressAdd", method = RequestMethod.GET)
    public String showAddAddress() {
        return "addressAdd";
    }

    @RequestMapping(value = "/addressAdd", method = RequestMethod.POST)
    public String doAddressAdd(@ModelAttribute("address") Address address, Principal principal) {
        Account account = accountDao.findByEmailWithDetails(principal.getName());
        addressDao.save(address);
        account.getAddress().add(address);
        accountDao.save(account);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public String showCompany(Model model, Principal principal) {
        Account account = accountDao.findByEmailWithDetails(principal.getName());
        Company company = companyDao.findByOwner(account);
        if (company == null)
            model.addAttribute("company", new Company());
        else
            model.addAttribute("company", company);
        return "company";
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public String doCreateCompany(@ModelAttribute("company") Company company, Principal principal) {
        Account account = accountDao.findByEmailWithDetails(principal.getName());
        company.setAccount(account);
        company.setCreationDate(new Date());
        companyDao.save(company);
        account.getRoleSet().add(roleDao.findByName("CEO"));
        accountDao.save(account);
        return "company";
    }

    @RequestMapping(value = "/company/{id}/addressAdd", method = RequestMethod.GET)
    public String showCompanyAddressAdd() {
        return "addressAdd";
    }

    @RequestMapping(value = "/company/{id}/addressAdd", method = RequestMethod.POST)
    public String doCompanyAddressAdd(@ModelAttribute("address") Address address, @PathVariable long id) {
        Company company = companyDao.findById(id);
        company.getAddressSet().add(address);
        addressDao.save(address);
        companyDao.save(company);
        return "redirect:/company";
    }

    @RequestMapping(value = "/company/{id}/addresses", method = RequestMethod.GET)
    public String showCompanyAddressList(Model model, @PathVariable long id) {
        List<Address> addressList = addressDao.findAll();
        Company company = companyDao.findById(id);
        Address tmp = new Address();
        for (Address includedAddress : company.getAddressSet()) {
            for (Address address : addressList)
                if (includedAddress.getId() == address.getId())
                    tmp = address;
            addressList.remove(tmp);
        }
        model.addAttribute("companyId", id);
        model.addAttribute("addresses", addressList);
        return "addresses";
    }

    @RequestMapping(value = "/company/{id}/addresses", method = RequestMethod.POST)
    public String doCompanyAddressAddFromListPage(@ModelAttribute("address") Address address, @PathVariable long id) {
        address.setId(null);
        addressDao.save(address);
        Company company = companyDao.findById(id);
        company.getAddressSet().add(address);
        companyDao.save(company);
        return "redirect:/company";
    }

    @RequestMapping(value = "/company/{companyId}/address/{addressId}")
    public String doCompanyAddressListAdd(@PathVariable long companyId, @PathVariable long addressId) {
        Address address = addressDao.findById(addressId);
        Company company = companyDao.findById(companyId);
        company.getAddressSet().add(address);
        companyDao.save(company);
        return "redirect:/company";
    }

    @RequestMapping(value = "/company/{id}/products/", method = RequestMethod.GET)
    public String showProducts(Model model, Principal principal, @PathVariable long id) {
        model.addAttribute("hostCompany", companyDao.findById(id));
        model.addAttribute("products", productDao.findByCompanyId(id));
        return "products";
    }
    @RequestMapping(value = "/company/{id}/products/", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product")Product product, @PathVariable long id) {
        product.setId(null);
        product.setCompany(companyDao.findById(id));
        productDao.save(product);
        return "redirect:/company/" + id + "/products/";
    }

    @RequestMapping(value = "/company/{hostCompanyId}/products/remove/{productId}")
    public String removeProductOfCompany(@PathVariable long hostCompanyId, @PathVariable long productId) {
        Product product = productDao.findById(productId);
        Company company = companyDao.findById(hostCompanyId);
        company.removeProduct(product);
        productDao.delete(product);
        companyDao.save(company);
        return "redirect:/company/" + hostCompanyId + "/products/";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String showAllProducts(Model model) {
        List<Product> productList = productDao.findAll();
        model.addAttribute("products", productList);
        return "productsAll";
    }

    @RequestMapping(value = "/products/buy/{productId}", method = RequestMethod.GET)
    public String showBuyProduct(@PathVariable long productId) {
        return "makeOrder";
    }

    @RequestMapping(value = "/products/buy/{productId}", method = RequestMethod.POST)
    public String doBuyProduct(@PathVariable long productId, @ModelAttribute("order") Order order, Principal principal) {
        Account account = accountDao.findByEmailWithDetails(principal.getName());
        Product product = productDao.findById(productId);
        order.setId(null);
        order.setOrderDate(new Date());
        order.setAccount(account);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setProduct(product);
        orderDetails.setOrder(order);
        orderDetails.setQuantity(0L);
        orderDetails.setUnitPrice(new BigDecimal(0));

        Set<OrderDetails> orderDetailsSet = new HashSet<OrderDetails>();
        orderDetailsSet.add(orderDetails);

        order.setOrderDetailsSet(orderDetailsSet);

        orderDao.save(order);
        return "makeOrder";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String showOrders(Model model) {
        List<Order> ord = orderDao.findAll();
        model.addAttribute("orders", orderDao.findAll());
        return "orders";
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String showOrderDetails(@PathVariable long id, Model model) {
        Order order = orderDao.findById(id);
        Set<OrderDetails> orderDetailsSet = order.getOrderDetailsSet();
        model.addAttribute("orderDetails", orderDetailsSet);
        return "orders";
    }
}
