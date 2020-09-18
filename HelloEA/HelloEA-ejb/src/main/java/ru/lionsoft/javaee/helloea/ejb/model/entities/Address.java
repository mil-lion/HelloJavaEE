/*
 * File:    Address.java
 * Project: HelloEA-ejb
 * Date:    24 дек. 2018 г. 13:06:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.helloea.ejb.model.entities;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Embeddable
@XmlType(propOrder = {"state", "city", "addressline1", "addressline2"})
@JsonbPropertyOrder({"state", "city", "addressline1", "addressline2"})
public class Address implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    // ************** Fields ***********************
 
    @Size(max = 30)
    @Column(length = 30)
    private String addressline1;
    
    @Size(max = 30)
    @Column(length = 30)
    private String addressline2;
    
    @Size(max = 25)
    @Column(length = 25)
    private String city;
    
    @Size(max = 2)
    @Column(length = 2)
    private String state;
    
    // ************** Constructors ***********************

    public Address() {
    }

    // ************** Getters & Setters ***********************

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // ************** Cast to String ***********************

    @Override
    public String toString() {
        return "Address{" + "addressline1=" + addressline1 + ", addressline2=" + addressline2 + ", city=" + city + ", state=" + state + '}';
    }
}
