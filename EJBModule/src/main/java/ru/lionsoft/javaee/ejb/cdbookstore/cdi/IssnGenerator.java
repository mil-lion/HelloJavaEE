/*
 * File:    IssnGenerator.java
 * Project: EJBModule
 * Date:    25 дек. 2018 г. 1:05:21
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import java.util.Random;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@EightDigits
@NumberOfDigits(value = Digits.EIGHT, odd = true)
public class IssnGenerator implements NumberGenerator {

    @Override
    public String generateNumber() {
        return "8-" + Math.abs(new Random().nextInt());
    }
    
}
