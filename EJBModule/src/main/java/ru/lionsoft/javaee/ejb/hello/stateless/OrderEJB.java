/*
 * File:    OrderEJB.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 13:06:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.stateless;

import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import ru.lionsoft.javaee.ejb.hello.entity.Customer;
import ru.lionsoft.javaee.ejb.hello.entity.bid.Order;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
@LocalBean
@Asynchronous
public class OrderEJB {

    @Resource
    private SessionContext ctx;

//    @Asynchronous
    public void sendEmailOrderComplete(Order order, Customer customer) {
        // Send e-mail
        System.out.println("Order #" + order.getOrderName() + "Send e-mail to " + customer.getEmail());
    }

//    @Asynchronous
    public void printOrder(Order order) {
        // Print order
        System.out.println("Print Order #" + order.getOrderName());
    }

    public Future<Integer> sendOrderToWorkflow(Order order) {
        Integer status = 0;
        // processing
        status = 1;
        if (ctx.wasCancelCalled()) {
            return new AsyncResult<Integer>(2);
        }
        // processing
        return new AsyncResult<Integer>(status);
    }
}
