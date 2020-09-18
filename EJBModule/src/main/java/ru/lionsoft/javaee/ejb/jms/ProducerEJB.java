/*
 * File:    ProducerEJB.java
 * Project: EJBModule
 * Date:    Feb 23, 2019 1:47:07 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.jms;

import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * The ProducerEJB Running inside a Container and using @Resource
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
@Remote(ProducerRemote.class)
public class ProducerEJB implements ProducerRemote {

    @Resource(lookup = "jms/DefaultConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "jms/InQueue")
    private Queue queue;

    @Override
    public void sendMessage() {
        try (JMSContext context = connectionFactory.createContext()) {
            context.createProducer().send(queue, "Text message sent at " + new Date());
        }
    }
}
