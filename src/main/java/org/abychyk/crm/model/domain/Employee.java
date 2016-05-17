package org.abychyk.crm.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Currency;
import java.util.Date;
import java.util.Set;

/**
 * Created by abychik on 16.05.2016.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "SALARY")
    private Currency salary;
    @Temporal(TemporalType.DATE)
    @Column(name = "HIRE_DATE")
    private Date hireDate;
    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;
    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Order> orderSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getSalary() {
        return salary;
    }

    public void setSalary(Currency salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
}
