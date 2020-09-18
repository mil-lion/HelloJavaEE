/*
 * File:    FromEightToThirteenDigitsDecorator.java
 * Project: EJBModule
 * Date:    25 дек. 2018 г. 13:30:52
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Decorator
public class FromEightToThirteenDigitsDecorator implements NumberGenerator {

    @Inject
    @Delegate
    private NumberGenerator numberGenerator;

    @Override
    public String generateNumber() {
        String issn = numberGenerator.generateNumber();
        String isbn = "13-84356" + issn.substring(1);
        return isbn;
    }
}
