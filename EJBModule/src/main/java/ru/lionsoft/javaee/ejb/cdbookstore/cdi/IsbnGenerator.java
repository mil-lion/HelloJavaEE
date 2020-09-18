/*
 * File:    IsbnGenerator.java
 * Project: EJBModule
 * Date:    25 дек. 2018 г. 1:05:21
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import java.util.Random;
import javax.enterprise.inject.Default;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@ThirteenDigits
@NumberOfDigits(value = Digits.THIRTEEN, odd = false)
public class IsbnGenerator implements NumberGenerator {

    @Override
    public String generateNumber() {
        return "13-84356-" + Math.abs(new Random().nextInt());
    }
    
}
