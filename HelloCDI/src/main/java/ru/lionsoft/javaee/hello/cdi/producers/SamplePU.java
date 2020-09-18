/*
 * File:    SamplePU.java
 * Project: HelloCDI
 * Date:    26 дек. 2018 г. 23:17:36
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.producers;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
@Qualifier
public @interface SamplePU {
    
}
