package org.abychyk.crm.model.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by abychik on 12.06.2016.
 */
@Entity
@Table(name = "ROLE")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @ManyToMany
    @JoinTable(name = "ROLE_ACCOUNT",
            joinColumns = @JoinColumn(name = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACCOUNT_ID"))
    private Set<Account> accountSet;

    public Set<Account> getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
