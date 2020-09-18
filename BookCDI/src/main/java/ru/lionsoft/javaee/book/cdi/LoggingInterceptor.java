/*
 * File:    LoggingInterceptor.java
 * Project: BookCDI
 * Date:    Jan 5, 2019 4:49:12 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.book.cdi;

import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Interceptor
@Loggable
public class LoggingInterceptor {
    
    @Inject
    private Logger logger;
    
    @AroundConstruct
    public Object init(InvocationContext ic) throws Exception {
        logger.fine("Entering constructor");
        System.out.println("Entering constructor");
        try {
            return ic.proceed();
        } finally {
            logger.fine("Exiting constructor");
            System.out.println("Exiting constructor");
        }
    }

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        logger.entering(ic.getTarget().getClass().getName(), ic.getMethod().getName());
        System.out.println("Entering: " + ic.getTarget().getClass().getName() + "::" + ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            logger.exiting(ic.getTarget().getClass().getName(), ic.getMethod().getName());
            System.out.println("Exiting: " + ic.getTarget().getClass().getName() + "::" + ic.getMethod().getName());
        }
    }
}
