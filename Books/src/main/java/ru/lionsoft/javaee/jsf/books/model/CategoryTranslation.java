/*
 * File:    CategoryTranslation.java
 * Project: Books
 * Date:    Jan 2, 2019 3:46:17 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
@Table(name = "CategoryTranslation")
public class CategoryTranslation implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ct_Id")
    private int id = -1;
    
    @Column(name = "ctCategoryId")
    private int categoryId = -1;
    
    @Column(name = "ctLanguage")
    private String language;
    
    @Column(name = "ctName")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        if (id < 0) {
            int hash = 7;
            hash = 61 * hash + this.categoryId;
            hash = 61 * hash + Objects.hashCode(this.language);
            return hash;
        }
        return id;
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
        final CategoryTranslation other = (CategoryTranslation) obj;
        if (id < 0 && other.id < 0) {
            return (this.categoryId == other.categoryId) 
                    && Objects.equals(this.language, other.language);
        }
        return id == other.id;
    }

    @Override
    public String toString() {
        return "CategoryTranslation{" + "id=" + id + ", categoryId=" + categoryId + ", language=" + language + ", name=" + name + '}';
    }
    
}
