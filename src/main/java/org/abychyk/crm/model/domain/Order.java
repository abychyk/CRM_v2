package org.abychyk.crm.model.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by abychik on 16.05.2016.
 */
@Entity
@Table(name = "ORDER")
public class Order implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "REQUIRED_DATE")
    private Date requiredDate;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "SHIPPED_DATE")
    private Date shippedDate;
    @Column(name = "SHIP_ADDRESS")
    private String shipAddress;
    @Column(name = "SHIP_CITY")
    private String shipCity;
    @Column(name = "SHIP_COUNTRY")
    private String shipCountry;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OrderDetails> orderDetailsSet;
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
    /*@ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

   /* public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }*/

    public Set<OrderDetails> getOrderDetailsSet() {
        return orderDetailsSet;
    }

    public void setOrderDetailsSet(Set<OrderDetails> orderDetailsSet) {
        this.orderDetailsSet = orderDetailsSet;
    }
}
