/*
 * File:    OrderConsumer.java
 * Project: EJBClient
 * Date:    Feb 24, 2019 1:31:49 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.jms;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import ru.lionsoft.javaee.ejb.jms.OrderDTO;

/**
 * The OrderConsumer Consumes all the OrderDTO Messages
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class OrderConsumer {

    @Resource(lookup = "jms/DefaultConnectionFactory")
    private static ConnectionFactory connectionFactory;
    
    @Resource(lookup = "jms/Topic")
    private static Destination topic;

    public static void main(String[] args) {

/*        
        // Gets the JNDI context
        Context jndiContext = new InitialContext();
        
        // Looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/DefaultConnectionFactory");
        Destination topic = (Destination) jndiContext.lookup("jms/Topic");
*/

        // Loops to receive the messages
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            while (true) {
                OrderDTO order = jmsContext.createConsumer(topic).receiveBody(OrderDTO.class);
                System.out.println("Order received: " + order);
            }
        }
    }
}
