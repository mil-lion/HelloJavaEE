/*
 * File:    JmsConsumer.java
 * Project: EJBClient
 * Date:    Feb 23, 2019 2:09:45 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.jms;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * The Consumer Class Consumes Messages in a Synchronous Manner
 * 
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class JmsConsumer {

    public static void main(String[] args) {
        try {
            // Gets the JNDI context
            Context jndiContext = new InitialContext(); 
            
            // Looks up the administered objects
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/DefaultConnectionFactory");
            Destination queue = (Destination) jndiContext.lookup("jms/InQueue");
            
            // Loops to receive the messages
            try (JMSContext context = connectionFactory.createContext()) {
                while (true) {
                    String message = context.createConsumer(queue).receiveBody(String.class);
                    System.out.println("Message received: " + message);
                }
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
