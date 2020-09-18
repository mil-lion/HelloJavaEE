/*
 * File:    OrderShipmentUniClient.java
 * Project: EJBClient
 * Date:    23 дек. 2018 г. 18:15:20
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.jpa;

import javax.ejb.EJB;
import ru.lionsoft.javaee.ejb.hello.entity.uni.Order;
import ru.lionsoft.javaee.ejb.hello.jpa.OrderShipmentUni;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class OrderShipmentUniClient {

    @EJB
    private static OrderShipmentUni os;
    
    public static void main(String[] args) {
        
        os.doSomeStuff();
        System.out.println("Unidirectional One-To-One client\n");

        for (Order order : os.getOrders()) {
            System.out.println("Order #" + order.getId() 
                    + ": " + order.getOrderName());
            System.out.println("\tShipment details: " 
                    + order.getShipment().getCity() 
                    + " "
                    + order.getShipment().getZipCode());
        }
    }
}
