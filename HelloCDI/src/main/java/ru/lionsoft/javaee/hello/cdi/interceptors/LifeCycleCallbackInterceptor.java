/*
 * File:    LifeCycleCallbackInterceptor.java
 * Project: HelloCDI
 * Date:    Jan 6, 2019 2:37:01 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.interceptors;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundTimeout;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class LifeCycleCallbackInterceptor {
    
    @Inject
    private Logger logger;
    
    /*
    It’s helpful to think of Interceptors as components which can interpose 
    on beans throughout their life cycle
    - before they are even constructed – @AroundConstruct
    - after they are constructed – @PostConstruct
    - during their life time (method invocation) – @AroundInvoke
    - prior to destruction – @PreDestroy
    - time outs of EJBs – @AroundTimeout
    */
    
    /**
     * Перехватчик конструктора класса
     * 
     * @param ic
     * @return
     * @throws Exception 
     */
    @AroundConstruct
    public Object beforeCreation(InvocationContext ic) throws Exception {
        logger.fine("Entering constructor");
        System.out.println("Entering constructor: " + ic.getConstructor());
        try {
            return ic.proceed();
        } finally {
            logger.fine("Exiting constructor");
            System.out.println("Exiting constructor: " + ic.getConstructor());
        }
    }
   
    /**
     * Перехватчик пост конструктора класса
     * 
     * @param ic 
     */
    @PostConstruct
    public void afterCreation(InvocationContext ic) {
        logger.entering(ic.getTarget().toString(), "@PpostConstruct");
        System.out.println("Entering @PostConstruct for " + ic.getTarget());
        try {
            ic.proceed();
        } catch (Exception ex) {
        } finally {
            logger.exiting(ic.getTarget().toString(), "@PostConstruct");
            System.out.println("Exiting @PostConstruct for " + ic.getTarget());
        }
    }
    
    /**
     * Перехватчик пре деструктора
     * 
     * @param ic 
     */
    @PreDestroy
    public void beforeDestruction(InvocationContext ic) {
        logger.entering(ic.getTarget().toString(), "@PostDestroy");
        System.out.println("Entering @PostDestroy for " + ic.getTarget());
        try {
            ic.proceed();
        } catch (Exception ex) {
        } finally {
            logger.exiting(ic.getTarget().toString(), "@PreDestroy");
            System.out.println("Exiting @PostDestroy for " + ic.getTarget());
        }
    }
    
    /**
     * 
     * @param ic
     * @return
     * @throws Exception 
     */
    @AroundTimeout
    public Object timeout(InvocationContext ic) throws Exception {
        System.out.println("Timer: " + ic.getTimer());
        logger.entering(ic.getTarget().toString(), "@AroundTimeout");
        System.out.println("Entering @AroundTimeout for " + ic.getTarget());
        try {
            return ic.proceed();
        } finally {
            logger.exiting(ic.getTarget().toString(), "@AroundTimeout");
            System.out.println("Exiting @AroundTimeout for " + ic.getTarget());
        }
    }
    
}
