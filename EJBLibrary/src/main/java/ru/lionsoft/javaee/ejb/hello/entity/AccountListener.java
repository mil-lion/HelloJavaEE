/*
 * File:    AccountListener.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 17:53:49
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity;

import javax.persistence.PrePersist;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class AccountListener {
    
    @PrePersist
    void prePersist(Account account) {
        System.out.println("AccountListener.prePersist called for " + account);
    }
    
    
}
