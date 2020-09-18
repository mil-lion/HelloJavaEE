/*
 * File:    MerlotWine.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 9:51:25 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.producers;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class MerlotWine implements Wine {

    @Override
    public String getName() {
        return "Merlot";
    }
    
   @Override
    public String getColor() {
        // color='#cb5382'
        return "Rose";
    }
    
}
