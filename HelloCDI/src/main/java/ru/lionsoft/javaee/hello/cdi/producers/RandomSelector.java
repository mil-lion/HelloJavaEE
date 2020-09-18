/*
 * File:    RandomSelector.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 9:52:37 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.producers;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
@Qualifier
public @interface RandomSelector {
}
