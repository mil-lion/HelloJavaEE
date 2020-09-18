/*
 * File:    HelloClient.java
 * Project: EJBClient
 * Date:    23 дек. 2018 г. 22:19:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.ejb32;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import ru.lionsoft.javaee.ejb.hello.ejb32.Hello;

/**
 * This class is an example of client code which invokes
 * methods on a simple, remote stateless session bean.
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class HelloClient {

    public static void main(String[] args) throws Exception {
        /*
         * Setup properties for JNDI initialization.
         *
         * These properties will be read in from
         * the command line.
         */
        Properties props = System.getProperties();

        /*
         * Obtain the JNDI initial context.
         *
         * The initial context is a starting point for
         * connecting to a JNDI tree.
         */
        Context ctx = new InitialContext(props);
//        Hello hello = (Hello) ctx.lookup("ru.lionsoft.javaee.ejb.hello.ejb32.Hello");
        Hello hello = (Hello) ctx.lookup(Hello.class.getName());

        /*
         * Call the hello() method on the bean.
         * We then print the result to the screen.
         */
        System.out.println(hello.hello());
    }
}
