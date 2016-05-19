package org.abychyk.crm.model.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by abychik on 09.05.2016.
 */
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "BUILDING_NUMBER")
    private String buildingNumber;
    @Column(name = "STREET_NAME")
    private String street;
    @Column(name = "CITY_NAME")
    private String city;
    @Column(name = "COUNTRY_NAME")
    private String country;
    @Column(name = "ZIP_CODE")
    private String zip;
/*    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    /*public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }*/

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }
}
