/*
 * File:    CountBean.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:57:58
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.stateful;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

/**
 * A Stateful Session Bean Class that shows the basics of
 * how to write a stateful session bean.
 *
 * This Bean is initialized to some integer value. It has a
 * business method which increments the value.
 *
 * The annotations below declare that:
 * <ul>
 * <li>this is a Stateful Session Bean
 * <li>the bean’s remote business interface is <code>Count</code>
 * <li>any lifecycle callbacks go to the class
 * <code>CountCallbacks</code>
 * </ul>
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateful
@Remote(Count.class)
@Interceptors(CountCallbacks.class)
public class CountBean implements Count {

    /** The current counter is our conversational state. */
    private int val;

    /**
     * The count() business method.
     */
    @Override
    public int count() {
        System.out.println("CountBean::count");
        return ++val;
    }

    /**
     * The set() business method.
     */
    @Override
    public void set(int val) {
        this.val = val;
        System.out.println("CountBean::set");
    }

    /**
     * The remove method is annotated so that the container knows
     * it can remove the bean after this method returns.
     */
    @Override
    @Remove
    public void remove() {
        System.out.println("CountBean::remove");
    }
    
}
