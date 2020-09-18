/*
 * File:    Consumer.java
 * Project: EJBClient
 * Date:    Feb 23, 2019 1:41:58 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * The Consumer Class Consumes a Message from a Queue using the Classic API
 * 
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class Consumer {

    public static void main(String[] args) throws JMSException {
        try {
            // Gets the JNDI context
            Context jndiContext = new InitialContext(); 
            
            // Looks up the administered objects
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/DefaultConnectionFactory");
            Destination queue = (Destination) jndiContext.lookup("jms/InQueue");
            
            // Creates the needed artifacts to connect to the queue
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(queue);
            connection.start();
            
            // Loops to receive the messages
            while (true) {
                TextMessage message = (TextMessage) consumer.receive();
                System.out.println("Message received: " + message.getText());
            }
        } catch (NamingException | JMSException ex) {
            ex.printStackTrace();
        }
    }
}
