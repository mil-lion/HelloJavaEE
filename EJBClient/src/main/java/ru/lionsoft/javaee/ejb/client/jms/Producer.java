/*
 * File:    Producer.java
 * Project: EJBClient
 * Date:    Feb 23, 2019 1:37:37 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.jms;

import java.util.Date;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * The Producer Class Produces a Message into a Queue using the Classic API
 * 
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class Producer {

    public static void main(String[] args) {
        try {
            // Gets the JNDI context
            Context jndiContext = new InitialContext();
            
            // Looks up the administered objects
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/DefaultConnectionFactory");
            Destination queue = (Destination) jndiContext.lookup("jms/InQueue");
            
            // Creates the needed artifacts to connect to the queue
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);
            
            // Sends a text message to the queue
            for (int i = 0; i < 10; i++) {
                TextMessage message = session.createTextMessage("Text message #" + i + " sent at " + new Date());
                producer.send(message);
                System.out.println("Message #" + i + " sended.");
                Thread.sleep(1000);
            }
            connection.close();
        } catch (NamingException | JMSException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
