/*
 * File:    WineDecorator.java
 * Project: HelloCDI
 * Date:    Jan 8, 2019 2:40:17 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.decorators;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Decorator
public abstract class WineDecorator implements Wine {

    @Inject 
    @Delegate
    @Any
    private Wine wine;
    
    @Override
    public String getName() {
        String color = "black";
        switch (wine.getColor()) {
            case Red:
                color = "red";
                break;
            case White:
                color = "lightgrey";
                break;
            case Sparkling:
                color = "gold";
                break;
            case Rose:
//                color = "MistyRose";
//                color = "#b21c0e";
//                color = "#cb0e40";
//                color = "#bc4f5e";
                color = "#cb5382";
                break;
        }
        return "<i><font color='" + color + "'>" + wine.getName() + "</font></i>";
    }
    
}
