package org.abychyk.crm.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by abychik on 09.05.2016.
 */
@Entity
@Table(name = "CASE")
public class Case implements Serializable {
    public enum Priority {LOW, NORMAL, HIGH}
    public enum Status {NEW, IN_WORK, CLOSED}
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CASE_NAME")
    private String name;
    @Column(name = "CASE_DESCRIPTION")
    private String description;
    @Column(name = "CASE_TYPE")
    private String type;
    @Column(name = "CASE_REASON")
    private String reason;
    @Temporal(TemporalType.DATE)
    @Column(name = "CASE_DATE_OPEN")
    private Date dateOpen;
    @Temporal(TemporalType.DATE)
    @Column(name = "CASE_DATE_CLOSE")
    private Date dateClose;
    @Column(name = "CASE_PRIORITY")
    private Priority priority;
    @Column(name = "CASE_STATUS")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(Date dateOpen) {
        this.dateOpen = dateOpen;
    }

    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
