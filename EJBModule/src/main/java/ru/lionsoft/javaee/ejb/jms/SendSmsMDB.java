/*
 * File:    SendSmsMDB.java
 * Project: EJBModule
 * Date:    Feb 23, 2019 2:28:27 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.jms;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@MessageDriven(mappedName = "OutTopic")
public class SendSmsMDB implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("SendSmsMDB - Message received: " + message.getBody(String.class));
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
    
}
