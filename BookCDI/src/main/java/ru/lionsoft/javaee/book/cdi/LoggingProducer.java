/*
 * File:    LoggingProducer.java
 * Project: BookCDI
 * Date:    Jan 5, 2019 4:48:50 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.book.cdi;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class LoggingProducer {
    
    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
    
}
