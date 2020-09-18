/*
 * File:    CabernetWine.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 8:19:57 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.interceptors;

import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@ApplicationScoped
@Red
public class CabernetWine implements Wine {

    @Override
    public String getName() {
        return "Cabernet";
    }

    @Override
    public String getColor() {
        return "Red";
    }
    
    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        System.out.println("Entering " + ic.getTarget().getClass().getName() 
                + "::" + ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            System.out.println("Exiting " + ic.getTarget().getClass().getName() 
                    + "::" + ic.getMethod().getName());            
        }
    }

}
