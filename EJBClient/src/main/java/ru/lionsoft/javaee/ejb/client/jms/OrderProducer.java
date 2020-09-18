/*
 * File:    OrderProducer.java
 * Project: EJBClient
 * Date:    Feb 24, 2019 1:25:47 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.jms;

import java.util.Date;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import ru.lionsoft.javaee.ejb.jms.OrderDTO;

/**
 * The OrderProducer Sends an OrderDTO
 * 
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class OrderProducer {
   
    @Resource(lookup = "jms/DefaultConnectionFactory")
    private static ConnectionFactory connectionFactory;
    
    @Resource(lookup = "jms/Topic")
    private static Destination topic;
    
    public static void main(String[] args) {
        
        // Creates an orderDto with a total amount parameter
        Float totalAmount = Float.valueOf(args[0]);
        OrderDTO order = new OrderDTO(1234L, new Date(), "Betty Moreau", totalAmount);

/*        
        // Gets the JNDI context
        Context jndiContext = new InitialContext();
        
        // Looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory)jndiContext.lookup("jms/DefaultConnectionFactory");
        Destination topic = (Destination)jndiContext.lookup("jms/Topic");
*/
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            // Sends an object message to the topic
            jmsContext.createProducer()
                    .setProperty("orderAmount", totalAmount)
                    .send(topic, order);
        }
    }
}
