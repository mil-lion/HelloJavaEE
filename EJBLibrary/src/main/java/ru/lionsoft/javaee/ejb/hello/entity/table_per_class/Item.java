/*
 * File:    Item.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 23:03:22
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity.table_per_class;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    protected String title;
    
    protected Float price;
    
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
