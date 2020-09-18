/*
 * File:    NumberProducer.java
 * Project: EJBModule
 * Date:    25 дек. 2018 г. 9:56:47
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import javax.enterprise.inject.Produces;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class NumberProducer {

    @Produces
    @ThirteenDigits
    private String prefix13digits = "13-";
    
    @Produces
    @ThirteenDigits
    private int editorNumber = 84356;

    @Produces
    @Random
    public double random() {
        return Math.abs(new java.util.Random().nextInt());
    }
}
