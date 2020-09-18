/*
 * File:    WhiteWine.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 8:37:25 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.events;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class WhiteWine implements Wine {

    @Override
    public String getColor() {
        return "<font color='lightgray'>White</font>";
    }
    
}
