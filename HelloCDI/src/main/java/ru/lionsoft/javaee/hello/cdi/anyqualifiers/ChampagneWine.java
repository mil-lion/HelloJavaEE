/*
 * File:    ChampagneWine.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 9:00:24 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.anyqualifiers;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Sparkling
public class ChampagneWine implements Wine {

    @Override
    public String getName() {
        return "Champagne";
    }

    @Override
    public String getColor() {
        return "Sparkling";
    }
    
}
