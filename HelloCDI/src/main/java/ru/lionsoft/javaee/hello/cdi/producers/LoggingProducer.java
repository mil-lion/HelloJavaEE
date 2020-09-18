/*
 * File:    LoggingProducer.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 4:48:50 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.producers;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Производитель данных автоматического журнала
 * 
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class LoggingProducer {
    
    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        String className = injectionPoint.getMember().getDeclaringClass().getName();
        System.out.println("@@@@ Produce Logger for Class: " + className);
        return Logger.getLogger(className);
    }
    
}
