/*
 * File:    ProducerCDI.java
 * Project: EJBModule
 * Date:    Feb 23, 2019 1:52:42 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.jms;

import java.util.Date;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSPasswordCredential;
import javax.jms.Queue;

/**
 * A Managed Bean Producing a Message using @Inject
 * 
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class ProducerCDI {

    @Inject
    @JMSConnectionFactory("jms/DefaultConnectionFactory")
//    @JMSPasswordCredential(userName="admin",password="mypassword")
    private JMSContext context;
    
    @Resource(lookup = "jms/InQueue")
    private Queue queue;

    public void sendMessage() {
        context.createProducer().send(queue, "Text message sent at " + new Date());
    }
}
