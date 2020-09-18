/*
 * File:    ChardonnayWine.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 8:37:25 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.interceptors;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.interceptor.Interceptors;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@RequestScoped
@White
@Default
@Interceptors({LoggingInterceptor.class, LifeCycleCallbackInterceptor.class})
public class ChardonnayWine implements Wine {

    @Override
    public String getName() {
        return "Chardonnay";
    }

    @Override
    public String getColor() {
        return "White";
    }
    
}
