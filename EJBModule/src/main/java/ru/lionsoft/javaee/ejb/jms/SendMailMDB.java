/*
 * File:    SendSmsMDB.java
 * Project: EJBModule
 * Date:    Feb 23, 2019 2:28:27 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.jms;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSSessionMode;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@MessageDriven(mappedName = "OutTopic")
public class SendMailMDB implements MessageListener {

    @Resource
    private MessageDrivenContext context;
    
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("SendMailMDB - Message received: " + message.getBody(String.class));
        } catch (JMSException ex) {
            ex.printStackTrace();
            // For use BMTs or container-managed transactions (CMTs)
            context.setRollbackOnly();
        }
    }
    
}
