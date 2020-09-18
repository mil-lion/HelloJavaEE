/*
 * File:    Wine.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 8:19:31 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.producers;

/**
 * Интерфейс описывающий объект Вино
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public interface Wine {
 
    /**
     * Получить название вина
     * @return название вина
     */
    String getName();
    
    /**
     * Получить цвет вина
     * @return цвет вина
     */
    String getColor();
}
