/*
 * File:    OrderShipmentBidBean.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:04:10
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ru.lionsoft.javaee.ejb.hello.entity.bid.Order;
import ru.lionsoft.javaee.ejb.hello.entity.bid.Shipment;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
public class OrderShipmentBidBean implements OrderShipmentBid {

    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;

    @Override
    public void doSomeStuff() {
        Shipment shipment = new Shipment();
        shipment.setCity("Austin");
        shipment.setZipCode("78727");
        
        Order order = new Order();
        order.setOrderName("Software Order");
        order.setShipment(shipment);
        em.persist(order);
    }

    @Override
    public List<Order> getOrders() {
        Query q = em.createQuery("SELECT o FROM OrderBid o");
        return q.getResultList();
    }

    @Override
    public List<Shipment> getShipments() {
        Query q = em.createQuery("SELECT s FROM ShipmentBid s");
        return q.getResultList();
    }
}
