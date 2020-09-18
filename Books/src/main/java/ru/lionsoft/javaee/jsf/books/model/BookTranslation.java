/*
 * File:    BookTranslation.java
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
import javax.validation.constraints.Size;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
@Table(name = "BookTranslation")
public class BookTranslation implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "btId")
    private int id = -1;
    
    @Column(name = "btBookId")
    private int bookId = -1;
    
    @Size(max = 10)
    @Column(name = "btLanguage", length = 10)
    private String language;
    
    @Size(max = 500)
    @Column(name = "btShorttext", length = 500)
    private String shortText;

    @Size(max = 50)
    @Column(name = "btReference", length = 50)
    private String reference;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public int hashCode() {
        if (id < 0) {
            int hash = 7;
            hash = 61 * hash + this.bookId;
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
        final BookTranslation other = (BookTranslation) obj;
        if (id < 0 && other.id < 0) {
            return (this.bookId == other.bookId) 
                    && Objects.equals(this.language, other.language);
        }
        return id == other.id;
    }

    @Override
    public String toString() {
        return "BookTranslation{" + "id=" + id + ", bookId=" + bookId + ", language=" + language + ", shortText=" + shortText + ", reference=" + reference + '}';
    }
}
