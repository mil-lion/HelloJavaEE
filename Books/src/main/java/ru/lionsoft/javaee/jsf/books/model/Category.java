/*
 * File:    Category.java
 * Project: Books
 * Date:    Dec 30, 2018 11:38:01 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
@Table(name = "Category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catId")
    private int id = -1;

    @Column(name = "catName")
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "ctCategoryId", referencedColumnName = "catId")
    @MapKey(name = "language")
    private Map<String, CategoryTranslation> catTranslations = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, CategoryTranslation> getCatTranslations() {
        return catTranslations;
    }

    public void setCatTranslations(Map<String, CategoryTranslation> catTranslations) {
        this.catTranslations = catTranslations;
    }

    public String getTranslatedName(String langCode) {
        if (catTranslations.containsKey(langCode)) {
            return catTranslations.get(langCode).getName();
        }
        return "";
    }

    public void setTranslatedName(String langCode, String name) {
        if (catTranslations.containsKey(langCode)) {
            catTranslations.get(langCode).setName(name);
        } else {
            CategoryTranslation translation = new CategoryTranslation();
            translation.setLanguage(langCode);
            translation.setCategoryId(id);
            translation.setName(name);
            catTranslations.put(langCode, translation);
        }
    }

    public String getTranslatedNameOrDefault(String langCode) {
        if (catTranslations.containsKey(langCode)) {
            String nm = catTranslations.get(langCode).getName();
            if (nm.isEmpty()) {
                return name;
            }
            return nm;
        }
        return name;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        return hash;
//        if (id < 0) {
//            return name.hashCode();
//        }
//        return id;
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
        final Category other = (Category) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name  + '}';
    }

}
