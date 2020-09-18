/*
 * File:    BankBean.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:45:25
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ru.lionsoft.javaee.ejb.hello.entity.Account;

/**
 * Stateless session bean facade for account entities,
 * remotely accessible
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
@Remote(Bank.class)
public class BankBean implements Bank {
    
    /* the entity manager object, injected by the container */
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;

    @Override
    public Account openAccount(String ownerName) {
        Account account = new Account();
        account.ownerName = ownerName;
        em.persist(account);
        return account;
    }

    @Override
    public int getBalance(int accountNumber) {
        Account account = em.find(Account.class, accountNumber);
        return account.balance;
    }

    @Override
    public void deposit(int accountNumber, int amount) {
        Account account = em.find(Account.class, accountNumber);
        account.deposit(amount);
    }

    @Override
    public int withdraw(int accountNumber, int amount) {
        Account account = em.find(Account.class, accountNumber);
        return account.withdraw(amount);
    }

    @Override
    public void close(int accountNumber) {
        Account account = em.find(Account.class, accountNumber);
        em.remove(account);
    }
    
}
