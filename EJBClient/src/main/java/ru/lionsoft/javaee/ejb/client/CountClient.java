/*
 * File:    CountClient.java
 * Project: EJBClient
 * Date:    24 дек. 2018 г. 12:19:15
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ru.lionsoft.javaee.ejb.hello.stateful.Count;

/**
 * This class is a simple client for a stateful session bean. To illustrate how
 * passivation works, configure your EJB server to allow only 2 stateful session
 * beans in memory. (Consult your vendor documentation for details on how to do
 * this.) We create 3 beans in this example to see how and when beans are
 * passivated.
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class CountClient {

    public static final int numOfClients = 3;

    public static void main(String[] args) {
        try {
            Properties enviroment = System.getProperties();
            
            /* Get a reference to the bean */
            Context ctx = new InitialContext(enviroment);
            
            /* An array to hold the Count beans */
            Count count[] = new Count[numOfClients];
            
            int countVal = 0;
            
            /* Create and count() on each member of array */
            System.out.println("Instantiating beans...");
            for (int i = 0; i < numOfClients; i++) {
                count[i] = (Count) ctx.lookup(Count.class.getName());
                
                /* initialize each bean to the current count value */
                count[i].set(countVal);
                
                /* Add 1 and print */
                countVal = count[i].count();
                System.out.println(countVal);
                
                /* Sleep for 1/2 second */
                Thread.sleep(100);
            }
            
            /*
             * Let’s call count() on each bean to make sure the
             * beans were passivated and activated properly.
             */
            System.out.println("Calling count() on beans...");
            for (int i = 0; i < numOfClients; i++) {
                /* Add 1 and print */
                countVal = count[i].count();
                System.out.println(countVal);
  
                /* let the container dispose of the bean */
                count[i].remove();
                
                /* Sleep */
                Thread.sleep(50);
            }
        } catch (InterruptedException | NamingException e) {
            e.printStackTrace();
        }
    }
}
