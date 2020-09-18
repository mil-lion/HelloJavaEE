/*
 * File:    MockGenerator.java
 * Project: EJBModule
 * Date:    25 дек. 2018 г. 9:42:59
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import javax.enterprise.inject.Alternative;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Alternative
public class MockGenerator implements NumberGenerator {

    @Override
    public String generateNumber() {
        return "MOCK";
    }
    
}
