/*
 * File:    IsbnGenerator.java
 * Project: BookCDI
 * Date:    Jan 5, 2019 4:46:47 PM
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
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {
    
    @Inject
    private Logger logger;
    
    @Override
    @Loggable
    public String generateNumber() {
        String isbn = "13-84356-" + Math.abs(new Random().nextInt());
        logger.log(Level.INFO, "Сгенерирован ISBN: {0}", isbn);
        return isbn;
    }
}
