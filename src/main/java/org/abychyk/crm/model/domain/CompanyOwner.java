package org.abychyk.crm.model.domain;

import javax.persistence.*;

/**
 * Created by abychik on 16.05.2016.
 */
@Entity
@Table(name = "COMPANY_OWNER")
public class CompanyOwner {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
