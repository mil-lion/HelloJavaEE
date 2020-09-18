/*
 * File:    CabernetWine.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 9:49:50 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.producers;

import javax.enterprise.inject.Default;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Default
public class CabernetWine implements Wine {

    @Override
    public String getName() {
        return "Cabernet";
    }
    
    @Override
    public String getColor() {
        return "Red";
    }
    
}
