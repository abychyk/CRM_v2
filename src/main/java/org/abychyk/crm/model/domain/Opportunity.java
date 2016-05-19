package org.abychyk.crm.model.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by abychik on 09.05.2016.
 */
@Entity
@Table(name = "OPPORTUNITY")
public class Opportunity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "OPPORTUNITY_NAME")
    private String name;
    @Column(name = "OPPORTUNITY_AMOUNT")
    private Long amount;
    @Column(name = "PROBABILITY")
    private int probability;
    @Temporal(TemporalType.DATE)
    @Column(name = "OPPORTUNITY_CLOSE_DATE")
    private Date closeDate;
    @ManyToOne
    @JoinColumn(name = "INIT_COMPANY_ID")
    private Company initCompany;
    @ManyToOne
    @JoinColumn(name = "REF_COMPANY_ID")
    private Company refCompany;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }


    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Company getInitCompany() {
        return initCompany;
    }

    public void setInitCompany(Company initCompany) {
        this.initCompany = initCompany;
    }

    public Company getRefCompany() {
        return refCompany;
    }

    public void setRefCompany(Company refCompany) {
        this.refCompany = refCompany;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
