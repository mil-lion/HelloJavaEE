/*
 * File:    CreditCard.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 22:56:00
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
@Table(name = "credit_card")
public class CreditCard implements Serializable {

    @Id
    private String number;

    private String expiryDate;

    private Integer controlNumber;

    @Enumerated(EnumType.STRING)
    private CreditCardType creditCardType;

    // Constructors, getters, setters

    public CreditCard() {
    }

    public CreditCard(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Integer controlNumber) {
        this.controlNumber = controlNumber;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    @Override
    public String toString() {
        return "CreditCard{" + "number=" + number + ", expiryDate=" + expiryDate + ", controlNumber=" + controlNumber + ", creditCardType=" + creditCardType + '}';
    }
}
