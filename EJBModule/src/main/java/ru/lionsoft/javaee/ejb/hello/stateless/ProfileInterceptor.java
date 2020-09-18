/*
 * File:    ProfileInterceptor.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:43:42
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.stateless;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class ProfileInterceptor {

    private static final Logger LOG = Logger.getLogger(ProfileInterceptor.class.getName());

    @PostConstruct
    public void logMethod(InvocationContext ic) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        
        System.out.println(df.format(new Date()) + " Enteging into " + ic.getTarget().toString() + "::" + ic.getMethod().getName());
        LOG.entering(ic.getTarget().toString(), ic.getMethod().getName());
        try {
            ic.proceed();
        } finally {
            System.out.println(df.format(new Date()) + " Exiting from " + ic.getTarget().toString() + "::" + ic.getMethod().getName());
            LOG.exiting(ic.getTarget().toString(), ic.getMethod().getName());
        }
    }

    @PreDestroy
    public void profile(InvocationContext ic) throws Exception {
        long initTime = System.currentTimeMillis();
        try {
            ic.proceed();
        } finally {
            long diffTime = System.currentTimeMillis() - initTime;
            System.out.println("Profile Method: " + ic.getMethod() + " took " + diffTime + " millis");
            LOG.log(Level.FINE, "{0} took {1} millis", new Object[]{ic.getMethod(), diffTime});
        }
    }
}
