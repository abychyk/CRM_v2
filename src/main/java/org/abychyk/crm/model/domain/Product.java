package org.abychyk.crm.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Currency;
import java.util.Set;

/**
 * Created by abychik on 09.05.2016.
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
    @Id @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRODUCT_NAME")
    private String name;
    @Column(name = "PRODUCT_DESCRIPTION")
    private String description;
    @Column(name = "PRODUCT_CODE")
    private String productCode;
    @Column(name = "DEFAULT_PRICE")
    private Currency defaultPrice;
    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;
    /*@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<OrderDetails> orderDetailsSet;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Case> caseSet;*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Currency getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(Currency defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    /*public Set<Case> getCaseSet() {
        return caseSet;
    }

    public void setCaseSet(Set<Case> caseSet) {
        this.caseSet = caseSet;
    }

    public Set<OrderDetails> getOrderDetailsSet() {
        return orderDetailsSet;
    }

    public void setOrderDetailsSet(Set<OrderDetails> orderDetailsSet) {
        this.orderDetailsSet = orderDetailsSet;
    }*/
}
