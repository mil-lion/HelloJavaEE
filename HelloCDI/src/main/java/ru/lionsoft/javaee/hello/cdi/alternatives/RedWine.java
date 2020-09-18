/*
 * File:    RedWine.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 8:19:57 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.alternatives;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class RedWine implements Wine {

    @Override
    public String getName() {
        return "Cabernet";
    }

    @Override
    public String getColor() {
        return "Red";
    }
    
}
