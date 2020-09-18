/*
 * File:    ApplicationConfig.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:14:37
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.ws.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    
}
