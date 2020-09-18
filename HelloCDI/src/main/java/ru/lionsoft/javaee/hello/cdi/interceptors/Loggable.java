/*
 * File:    Loggable.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 4:49:38 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.interceptors;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

/**
 * Связывание с перехватчиком Loggable
 * 
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@InterceptorBinding
@Target({METHOD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable {
    
}
