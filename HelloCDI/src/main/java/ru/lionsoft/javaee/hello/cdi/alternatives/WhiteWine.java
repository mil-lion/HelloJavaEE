/*
 * File:    WhiteWine.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 8:37:25 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.alternatives;

import javax.enterprise.inject.Alternative;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Alternative
public class WhiteWine implements Wine {

    @Override
    public String getName() {
        return "Chardonnay";
    }
 
    @Override
    public String getColor() {
        return "White";
    }
    
}
