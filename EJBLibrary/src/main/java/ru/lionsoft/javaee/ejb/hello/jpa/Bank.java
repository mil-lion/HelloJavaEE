/*
 * File:    Bank.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:07:06
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import ru.lionsoft.javaee.ejb.hello.entity.Account;

/**
 * Stateless session bean facade for account entities,
 * remotely accessible
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public interface Bank {
    
    Account openAccount(String ownerName);
    
    int getBalance(int accountNumber);
    
    void deposit(int accountNumber, int amount);
    
    int withdraw(int accountNumber, int amount);
    
    void close(int accountNumber);
    
}
