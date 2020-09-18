/*
 * File:    CountCallbacks.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 12:03:52
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.stateful;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.interceptor.InvocationContext;

/**
 * This class is a lifecycle callback interceptor for the Count bean. The
 * callback methods simply print a message when invoked by the container.
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class CountCallbacks {

    /**
     * Called by the container after construction
     *
     * @param ctx invocation context
     */
    @PostConstruct
    public void construct(InvocationContext ctx) {
        System.out.println("Callback::construct");
    }

    /**
     * Called by the container after activation
     *
     * @param ctx invocation context
     */
    @PostActivate
    public void activate(InvocationContext ctx) {
        System.out.println("Callback::activate");
    }

    /**
     * Called by the container before passivation
     *
     * @param ctx invocation context
     */
    @PrePassivate
    public void passivate(InvocationContext ctx) {
        System.out.println("Callback::passivate");
    }

    /**
     * Called by the container before destruction
     *
     * @param ctx invocation context
     */
    @PreDestroy
    public void destroy(InvocationContext ctx) {
        System.out.println("Callback::destroy");
    }
}
