/*
 * File:    ProducerRemote.java
 * Project: EJBModule
 * Date:    Feb 23, 2019 1:50:06 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.jms;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public interface ProducerRemote {

    void sendMessage();
    
}
