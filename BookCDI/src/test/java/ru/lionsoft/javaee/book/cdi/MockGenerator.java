/*
 * File:    MockGenerator.java
 * Project: BookCDI
 * Date:    Jan 5, 2019 4:47:31 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.book.cdi;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {

    @Inject
    private Logger logger;
    
    @Override
    @Loggable
    public String generateNumber() {
        String mock = "MOCK-" + Math.abs(new Random().nextInt());
        logger.log(Level.INFO, "Сгенерирован Mock: {0}", mock);
        return mock;
    }
    
}
