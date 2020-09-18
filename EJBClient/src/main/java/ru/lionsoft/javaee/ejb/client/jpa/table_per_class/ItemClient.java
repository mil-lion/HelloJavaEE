/*
 * File:    ItemClient.java
 * Project: EJBClient
 * Date:    23 дек. 2018 г. 22:19:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.jpa.table_per_class;

import javax.ejb.EJB;
import ru.lionsoft.javaee.ejb.hello.jpa.ItemTablePerClass;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class ItemClient {

    @EJB
    private static ItemTablePerClass itpc;
    
    public static void main(String[] args) {
        itpc.doSomeStuff();
        for (Object item : itpc.getAllItems()) {
            System.out.println("Item: " + item);
        }
    }
}
