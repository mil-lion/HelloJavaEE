/*
 * File:    Count.java
 * Project: EJBLibrary
 * Date:    24 дек. 2018 г. 11:56:21
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.stateful;

/**
 * The business interface - a plain Java interface with only business methods.
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public interface Count {

    /**
     * Increments the counter by 1
     * @return count value
     */
    public int count();

    /**
     * Sets the counter to val
     *
     * @param val new value
     */
    public void set(int val);

    /**
     * removes the counter
     */
    public void remove();
}
