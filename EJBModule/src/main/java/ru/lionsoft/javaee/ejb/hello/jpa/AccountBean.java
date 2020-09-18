/*
 * File:    AccountBean.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:45:25
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import ru.lionsoft.javaee.ejb.hello.entity.Account;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateful
@Remote(AccountFacade.class)
public class AccountBean implements AccountFacade {

    @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = "TestPU")
    private EntityManager em;

    private Account account = null;

    @Override
    public void open(int accountNumber) {
        account = em.find(Account.class, accountNumber);
        if (account == null) {
            account = new Account();
            account.ownerName = "anonymous";
            account.accountNumber = accountNumber;
            em.persist(account);
        }
    }

    @Override
    public int getBalance() {
        if (account == null) {
            throw new IllegalStateException();
        }
        return account.balance;
    }

    @Override
    public void deposit(int amount) {
        if (account == null) {
            throw new IllegalStateException();
        }
        account.deposit(amount);
    }

    @Override
    public int withdraw(int amount) {
        if (account == null) {
            throw new IllegalStateException();
        }
        return account.withdraw(amount);
    }
    
    @Override
    public void update(Account detachedAccount) {
        Account managedAccount = em.merge(detachedAccount);
    }
    
    @Override
    public List<Account> listAccounts() {
//        Query query = em.createQuery("SELECT a FROM Account a");
        Query query = em.createNamedQuery("findThem");
        return query.getResultList();
    }
}
