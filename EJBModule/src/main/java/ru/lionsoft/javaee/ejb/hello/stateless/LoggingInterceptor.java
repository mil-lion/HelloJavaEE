/*
 * File:    LoggingInterceptor.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:37:08
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.stateless;

import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class LoggingInterceptor {

    private static final Logger LOG = Logger.getLogger(LoggingInterceptor.class.getName());

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        System.out.println("Entering method: " + ic.getTarget().toString() + "::" + ic.getMethod().getName());
        LOG.entering(ic.getTarget().toString(), ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            System.out.println("Exiting method: " + ic.getTarget().toString() + "::" + ic.getMethod().getName());
            LOG.exiting(ic.getTarget().toString(), ic.getMethod().getName());
        }
    }
}
