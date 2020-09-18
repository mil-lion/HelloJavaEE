/*
 * File:    HelloClient.java
 * Project: EJBClient
 * Date:    23 дек. 2018 г. 22:19:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.ejb21;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import ru.lionsoft.javaee.ejb.hello.ejb21.Hello;
import ru.lionsoft.javaee.ejb.hello.ejb21.HelloHome;

/**
 * This class is an example of client code that invokes methods on a simple
 * stateless session bean.
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
         * connecting to a JNDI tree. We choose our JNDI
         * driver, the network location of the server, etc.
         * by passing in the environment properties.
         */
        Context ctx = new InitialContext(props);
 
        /*
         * Get a reference to the home object - the
         * factory for Hello EJB Objects
         */
        Object obj = ctx.lookup(HelloHome.class.getName());

        /*
         * Home objects are RMI-IIOP objects, and so
         * they must be cast into RMI-IIOP objects
         * using a special RMI-IIOP cast.
         *
         * See Appendix A for more details on this.
         */
//        HelloHome home = (HelloHome) PortableRemoteObject.narrow(obj, HelloHome.class);

        /*
         * Use the factory to create the Hello EJB Object
         */
//        Hello hello = home.create();

        /*
         * Call the hello() method on the EJB object. The
         * EJB object will delegate the call to the bean,
         * receive the result, and return it to us.
         *
         * We then print the result to the screen.
         */
//        System.out.println(hello.hello());

        /*
         * Done with EJB Object, so remove it.
         * The container will destroy the EJB object.
         */
//        hello.remove();
    }
}
