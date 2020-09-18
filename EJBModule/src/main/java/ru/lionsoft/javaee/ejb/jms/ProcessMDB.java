/*
 * File:    ProcessMDB.java
 * Project: EJBModule
 * Date:    Feb 23, 2019 2:21:05 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.jms;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Destination;
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
@MessageDriven(mappedName = "jms/InQueue")
public class ProcessMDB implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("ProcessMDB - Message received: " + message.getBody(String.class));
            Thread.sleep(1000);
            sendOutMessage();
        } catch (JMSException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    // Send Message to Topic
    
    @Inject
    @JMSConnectionFactory("jms/DefaultConnectionFactory")
    @JMSSessionMode(JMSContext.AUTO_ACKNOWLEDGE)
    private JMSContext context;

    @Resource(lookup = "jms/OutTopic")
    private Destination outTopic;

    private void sendOutMessage() throws JMSException {
        context.createProducer().send(outTopic, "Message has been recseived and resent");
    }    
}
