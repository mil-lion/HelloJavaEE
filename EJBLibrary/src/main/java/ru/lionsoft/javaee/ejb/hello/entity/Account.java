/*
 * File:    Account.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 17:53:49
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Version;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
@EntityListeners(AccountListener.class)
@NamedQuery(name = "findThem", query = "SELECT a FROM Account a")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Version
    public int version;
    
    // The account number is the primary key
    @Id
    public int accountNumber;

    public String ownerName;

    public int balance;

    /**
    * Entities must have a public no-arg constructor
    */
    public Account() {
        // our own simple primary key generation
        accountNumber = (int) System.nanoTime();
    }    

    /**
     * Deposit a given amount
     * @param amount
     */
    public void deposit(int amount) {
       balance += amount;
    }
    
    /**
     * Withdraw a given amount, or 0 if it is larger than the balance
     * @param amount
     * @return The amount that was withdrawn
     */
    public int withdraw(int amount) {
        if (amount > balance) {
            return 0;
        } else {
            balance -= amount;
            return amount;
        }
    }    

    // ************ Callbacks *************
    
    @PrePersist
    void prePersist() {
        System.out.println("Account.prePersist called!");
    }
}
