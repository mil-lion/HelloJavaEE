/*
 * File:    ZipCodeEJB.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:16:59
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.singletone;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Singleton
public class ZipCodeEJB {

    @PostConstruct
    private void initCache() {
        // Initializes
        System.out.println("Initializes ZipCodeEJB");
    }
    
}
