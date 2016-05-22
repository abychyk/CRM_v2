package org.abychyk.crm.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by abychik on 12.05.2016.
 */
@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
        @NamedQuery(name = "Account.findAllWithAddress",
        query = "select distinct a from Account a left join fetch a.address ad")
})
public class Account implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Column(name = "PHONE")
    private String phone;
    @ManyToMany
    @JoinTable(name = "ACCOUNT_ADDRESS",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
        inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID"))
    private Set<Address> address;
    /*@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private CompanyOwner companyOwner;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Order> orderSet;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private  Set<Case> caseSet;
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Employee employee;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    /*public CompanyOwner getCompanyOwner() {
        return companyOwner;
    }

    public void setCompanyOwner(CompanyOwner companyOwner) {
        this.companyOwner = companyOwner;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    public Set<Case> getCaseSet() {
        return caseSet;
    }

    public void setCaseSet(Set<Case> caseSet) {
        this.caseSet = caseSet;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }*/
}
