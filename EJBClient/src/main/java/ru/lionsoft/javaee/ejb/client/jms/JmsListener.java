/*
 * File:    JmsListener.java
 * Project: EJBModule
 * Date:    Feb 23, 2019 2:03:13 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.jms;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * The Consumer Is a Message Listener (Asynchronous Delivery)
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class JmsListener implements MessageListener {

    public static void main(String[] args) {
        try {
            // Gets the JNDI context
            Context jndiContext = new InitialContext();
            
            // Looks up the administered objects
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/DefaultConnectionFactory");
            Destination queue = (Destination) jndiContext.lookup("jms/InQueue");
            
            try (JMSContext context = connectionFactory.createContext()) {
                context.createConsumer(queue).setMessageListener(new JmsListener());
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Async Message received: " + message.getBody(String.class));
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

}
