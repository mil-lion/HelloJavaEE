/*
 * File:    CdBookStoreClient.java
 * Project: EJBClient
 * Date:    23 дек. 2018 г. 22:19:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.client;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import ru.lionsoft.javaee.ejb.cdbookstore.beans.ItemRemote;
import ru.lionsoft.javaee.ejb.cdbookstore.entity.Book;
import ru.lionsoft.javaee.ejb.cdbookstore.entity.CD;

/**
 * This class is an example of client code which invokes
 * methods on a simple, remote stateless session bean.
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class CdBookStoreClient {

    public static void main(String[] args) throws Exception {
        /*
         * Setup properties for JNDI initialization.
         *
         * These properties will be read in from
         * the command line.
         */
        Properties props = new Properties();
        // "java.naming.factory.initial"
//        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.cosnaming.CNCtxFactory"); 
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.impl.SerialInitContextFactory");
        // "java.naming.provider.url"
        props.put(Context.PROVIDER_URL, "iiop://127.0.0.1:2215"); 

        /*
         * Obtain the JNDI initial context.
         *
         * The initial context is a starting point for
         * connecting to a JNDI tree.
         */
        Context ctx = new InitialContext(props);

        ItemRemote itemEjb = (ItemRemote) ctx.lookup(ItemRemote.class.getName());

        /*
         * Call the getBooks method on the bean.
         * We then print the result to the screen.
         */
        System.out.println("Books:");
        for (Book book : itemEjb.findBooks()) {
            System.out.println("\t" + book);
        }

        System.out.println("CDs:");
        for (CD cd : itemEjb.findCDs()) {
            System.out.println("\t" + cd);
        }
    }
}
