/*
 * File:    SparklingWine.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 9:00:24 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.events;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class SparklingWine implements Wine {

    @Override
    public String getColor() {
        return "<font color='gold'>Sparkling</font>";
    }
    
}
