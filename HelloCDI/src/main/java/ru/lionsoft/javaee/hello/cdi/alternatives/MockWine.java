/*
 * File:    MockWine.java
 * Project: HelloCDI
 * Date:    Jan 28, 2019 8:00:47 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.alternatives;

import javax.enterprise.inject.Alternative;

/**
 * Тестовая реализация интерфейса Вино (заглушка)
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Alternative
public class MockWine implements Wine {

     @Override
    public String getName() {
        return "Mock";
    }

    @Override
    public String getColor() {
        return "Mock";
    }
    
}
