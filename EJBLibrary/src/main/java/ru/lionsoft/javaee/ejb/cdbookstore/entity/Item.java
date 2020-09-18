/*
 * File:    Item.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 23:03:22
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@MappedSuperclass
public class Item implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue
    protected Long id;

    protected String title;

    protected Float price;

    @Transient
    protected String currency = "USD";
    
    protected String description;

    // Constructors

    public Item() {
    }
    
    public Item(Long id) {
        this.id = id;
    }

    // Getters, setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" 
                + "id=" + id 
                + ", title=" + title 
                + ", price=" + price 
                + ", description=" + description 
                + '}';
    }
    
}
