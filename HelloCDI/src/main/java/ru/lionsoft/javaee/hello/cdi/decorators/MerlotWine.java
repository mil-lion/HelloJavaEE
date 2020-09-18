/*
 * File:    MerlotWine.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 10:33:39 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.decorators;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Rose
public class MerlotWine implements Wine {

    @Override
    public String getName() {
        return "Merlot";
    }

    @Override
    public WineColor getColor() {
        return WineColor.Rose;
    }
    
}
