/*
 * File:    LoggingProducer.java
 * Project: EJBModule
 * Date:    25 дек. 2018 г. 9:53:44
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class LoggingProducer {

    @Produces
    private Logger createLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
