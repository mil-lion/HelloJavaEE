/*
 * File:    NumberOfDigits.java
 * Project: EJBModule
 * Date:    25 дек. 2018 г. 1:15:50
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
public @interface NumberOfDigits {

    Digits value();
    
    boolean odd();
}
