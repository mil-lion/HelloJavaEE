/*
 * File:    ChardonnayWine.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 8:37:25 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.qualifiers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@ApplicationScoped
@White
@Default
public class ChardonnayWine implements Wine {

    @Override
    public String getName() {
        return "Chardonney";
    }
    
    @Override
    public String getColor() {
        return "White";
    }
    
}
