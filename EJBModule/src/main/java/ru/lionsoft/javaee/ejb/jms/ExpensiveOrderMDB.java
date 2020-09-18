/*
 * File:    ExpensiveOrderMDB.java
 * Project: EJBModule
 * Date:    Feb 24, 2019 1:34:53 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSConnectionFactoryDefinition;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/*
Creating the Administered Objects into GlassFish
$ asadmin create-jms-resource --restype javax.jms.ConnectionFactory jms/ConnectionFactory
$ asadmin create-jms-resource --restype javax.jms.Topic jms/Topic
$ asadmin list-jms-resources
*/

/**
 * The ExpensiveOrderMDB only Consumes Orders with an Amount Greater than $1000
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@MessageDriven(mappedName = "jms/Topic", activationConfig
        = {
            @ActivationConfigProperty(
                    propertyName = "acknowledgeMode",
                    propertyValue = "Auto-acknowledge"),
            @ActivationConfigProperty(
                    propertyName = "messageSelector",
                    propertyValue = "orderAmount > 1000")
        }
)
// The ExpensiveOrderMDB Defining Administered Objects Programmatically (JMS 2.0)
@JMSConnectionFactoryDefinition(name = "jms/DefaultConnectionFactory", 
                        className = "javax.jms.ConnectionFactory")
@JMSDestinationDefinition(name = "jms/Topic", 
                        interfaceName = "javax.jms.Topic")
public class ExpensiveOrderMDB implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            OrderDTO order = message.getBody(OrderDTO.class);
            System.out.println("Expensive order received: " + order.toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
