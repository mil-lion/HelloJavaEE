/*
 * File:    OrderDTO.java
 * Project: EJBLibrary
 * Date:    Feb 24, 2019 1:23:41 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.jms;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The OrderDTO Is Passed in a JMS ObjectMessage
 * 
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class OrderDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long orderId; 
    
    private Date creationDate;
    
    private String customerName;
    
    private Float totalAmount;
    
    // Constructors, getters, setters

    public OrderDTO() {
    }

    public OrderDTO(Long orderId, Date creationDate, String customerName, Float totalAmount) {
        this.orderId = orderId;
        this.creationDate = creationDate;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.orderId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderDTO other = (OrderDTO) obj;
        if (!Objects.equals(this.orderId, other.orderId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderId=" + orderId + ", creationDate=" + creationDate + ", customerName=" + customerName + ", totalAmount=" + totalAmount + '}';
    }
        
}
