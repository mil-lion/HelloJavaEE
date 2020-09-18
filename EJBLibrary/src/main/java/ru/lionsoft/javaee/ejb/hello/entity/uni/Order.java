/*
 * File:    Order.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 17:53:49
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity.uni;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity(name = "OrderUni")
public class Order implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int id;
    private String orderName;
    private Shipment shipment;

    public Order() {
        id = (int) System.nanoTime();
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @OneToOne(cascade = {CascadeType.PERSIST})
    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", orderName=" + orderName + ", shipment=" + shipment + '}';
    }
       
}
