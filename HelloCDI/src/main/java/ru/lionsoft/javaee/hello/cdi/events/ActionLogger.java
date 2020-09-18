/*
 * File:    ActionLogger.java
 * Project: HelloCDI
 * Date:    Jan 8, 2019 11:58:46 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.events;

import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@ApplicationScoped
public class ActionLogger {
    
    @Inject
    private Logger logger;
    
    public void addWine(@Observes @Added Wine wine) {
        System.out.println("Added Wine: " + wine.getColor());
        logger.info("Added Wine: " + wine);
    }

    public void deleteWine(@Observes @Removed Wine wine) {
        System.out.println("Removed Wine: " + wine.getColor());
        logger.info("Removed Wine: " + wine);
    }
}
