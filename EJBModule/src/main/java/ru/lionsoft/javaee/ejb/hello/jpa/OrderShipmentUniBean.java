/*
 * File:    OrderShipmentUniBean.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:04:10
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ru.lionsoft.javaee.ejb.hello.entity.uni.Order;
import ru.lionsoft.javaee.ejb.hello.entity.uni.Shipment;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
public class OrderShipmentUniBean implements OrderShipmentUni {

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
        Query q = em.createQuery("SELECT o FROM OrderUni o");
        return q.getResultList();
    }
    
}
