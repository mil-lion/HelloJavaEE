/*
 * File:    IssnGenerator.java
 * Project: BookCDI
 * Date:    Jan 5, 2019 4:47:00 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.book.cdi;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@EightDigits
public class IssnGenerator implements NumberGenerator {

    @Inject
    private Logger logger;
    
    @Override
    @Loggable
    public String generateNumber() {
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.log(Level.INFO, "Сгенерирован ISSN: {0}", issn);
        return issn;
    }
    
}
