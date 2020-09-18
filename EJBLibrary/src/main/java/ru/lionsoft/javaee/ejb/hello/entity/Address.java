/*
 * File:    Address.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 23:44:59
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Address implements Serializable {
    
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    
    // Constructors, getters, setters

    @Column(nullable = false)
    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    @Column(nullable = false, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(length = 3)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "zip_code", length = 10)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" + "street1=" + street1 + ", street2=" + street2 + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", country=" + country + '}';
    }
}
