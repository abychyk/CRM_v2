package org.abychyk.crm.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by abychik on 09.05.2016.
 */
@Entity
@Table (name = "COMPANY")
public class Company implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "COMPANY_NAME")
    private String name;
    @Column(name = "ANNUAL_REVENUE")
    private BigDecimal annualRevenue;
    @Column(name = "COMPANY_PHONE")
    private String phone;
    @Column(name = "CREATION_DATE")
    private Date creationDate;
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private Set<Product> product;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "COMPANY_ADDRESS",
        joinColumns = @JoinColumn(name = "COMPANY_ID"),
        inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID"))
    private Set<Address> addressSet;
    @ManyToMany
    @JoinTable(name = "COMPANY_GROUP_DETAIL",
        joinColumns = @JoinColumn(name = "COMPANY_ID"),
        inverseJoinColumns = @JoinColumn(name = "GROUP_ID"))
    private Set<Group> groups;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
    /*@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CompanyOwner> companyOwners;*/
    /*@OneToMany(mappedBy = "initCompany", cascade = CascadeType.ALL)
    private Set<Opportunity> initOpporunitySet;
    @OneToMany(mappedBy = "refCompany", cascade = CascadeType.ALL)
    private Set<Opportunity> refOpportunitySet;*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(BigDecimal annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    /*public Set<CompanyOwner> getCompanyOwners() {
        return companyOwners;
    }

    public void setCompanyOwners(Set<CompanyOwner> companyOwners) {
        this.companyOwners = companyOwners;
    }*/

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void removeProduct(Product product) {
        Product tmp = new Product();
        for (Product includedProduct : getProduct()) {
            if (includedProduct.getId() == product.getId())
                tmp = includedProduct;
        }
        getProduct().remove(tmp);
    }

    /*public Set<Opportunity> getInitOpporunitySet() {
        return initOpporunitySet;
    }

    public void setInitOpporunitySet(Set<Opportunity> initOpporunitySet) {
        this.initOpporunitySet = initOpporunitySet;
    }

    public Set<Opportunity> getRefOpportunitySet() {
        return refOpportunitySet;
    }

    public void setRefOpportunitySet(Set<Opportunity> refOpportunitySet) {
        this.refOpportunitySet = refOpportunitySet;
    }*/
}
