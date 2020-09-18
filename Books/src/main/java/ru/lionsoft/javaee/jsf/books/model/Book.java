/*
 * File:    Book.java
 * Project: Books
 * Date:    Jan 2, 2019 7:25:10 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.model;

import java.io.Serializable;
import java.util.HashMap;
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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
@Table(name = "Book")
public class Book implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private int id = -1;
    
    @Size(max = 200)
    @Column(name = "bookTitle", length = 200)
    private String title;
    
    @Size(max = 200)
    @Column(name = "bookSubtitle", length = 200)
    private String subTitle;
    
    @Size(max = 255)
    @Column(name = "bookAuthor", length = 255)
    private String author;
    
//    @Pattern(regexp = ".*@.*", message = "Please enter a valid email address.")
//    @Pattern(regexp = ".*@.*", message = "{validation.constraints.email.message}")
    @Size(max = 45)
    @Column(name = "bookPublisher", length = 45)
    private String publisher;
    
    @Column(name = "bookYear", precision = 4)
    private Integer year;
    
    @Size(max = 10)
    @Column(name = "bookLanguage", length = 10)
    private String language;
    
    @Size(max = 45)
    @Column(name = "bookISBN", length = 45)
    private String isbn;
    
    @Size(max = 500)
    @Column(name = "bookShorttext", length = 500)
    private String shortText;
    
    @Size(max = 500)
    @Column(name = "bookReference", length = 500)
    private String reference;
    
    @Size(max = 50)
    @Column(name = "bookAdReference", length = 50)
    private String adReference;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "btBookId", referencedColumnName = "bookId")
    @MapKey(name = "language")
    private Map<String, BookTranslation> bookTranslations = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getAdReference() {
        return adReference;
    }

    public void setAdReference(String adReference) {
        this.adReference = adReference;
    }

    public Map<String, BookTranslation> getBookTranslations() {
        return bookTranslations;
    }

    public void setBookTranslations(Map<String, BookTranslation> bookTranslations) {
        this.bookTranslations = bookTranslations;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final Book other = (Book) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", subTitle=" + subTitle + ", author=" + author + ", publisher=" + publisher + ", year=" + year + ", language=" + language + ", isbn=" + isbn + ", shortText=" + shortText + ", reference=" + reference + ", adReference=" + adReference + '}';
    }
       
}
