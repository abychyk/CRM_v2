package org.abychyk.crm.model.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by abychik on 09.05.2016.
 */
@Entity
@Table(name = "GROUP")
public class Group {
    @Id @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "GROUP_NAME")
    private String name;
    @ManyToMany
    @JoinTable(name = "COMPANY_GROUP_DETAIL",
        joinColumns = @JoinColumn(name = "GROUP_ID"),
        inverseJoinColumns = @JoinColumn(name = "COMPANY_ID"))
    private Set<Company> companies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}
