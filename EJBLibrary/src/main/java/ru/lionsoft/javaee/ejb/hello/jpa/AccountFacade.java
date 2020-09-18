/*
 * File:    AccountFacade.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:07:06
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import java.util.List;
import ru.lionsoft.javaee.ejb.hello.entity.Account;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public interface AccountFacade {

    void open(int accountNumber);

    int getBalance();

    void deposit(int amount);

    int withdraw(int amount);
    
    void update(Account detachedAccount);

    public List<Account> listAccounts();
    
}
