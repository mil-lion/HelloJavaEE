/*
 * File:    Sparkling.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 8:57:13 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.anyqualifiers;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 * Квалификатор - Игристое
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Qualifier
@Target({METHOD, FIELD, PARAMETER, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Sparkling {
    
}
