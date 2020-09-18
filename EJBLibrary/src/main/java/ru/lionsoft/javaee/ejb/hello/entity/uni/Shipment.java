/*
 * File:    Shipment.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 17:56:47
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity.uni;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity(name = "ShipmentUni")
public class Shipment implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int id;
    private String city;
    private String zipCode;

    public Shipment() {
        id = (int) System.nanoTime();
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Shipment{" + "id=" + id + ", city=" + city + ", zipCode=" + zipCode + '}';
    }
}
