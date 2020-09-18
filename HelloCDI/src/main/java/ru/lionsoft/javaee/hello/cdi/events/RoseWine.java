/*
 * File:    RoseWine.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 10:33:39 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.events;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class RoseWine implements Wine {

    @Override
    public String getColor() {
        return "<font color='#cb5382'>Rose</font>";
    }
    
}
