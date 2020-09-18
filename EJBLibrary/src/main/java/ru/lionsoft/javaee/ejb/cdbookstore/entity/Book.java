/*
 * File:    Book.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 22:48:07
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "book_id")),
    @AttributeOverride(name = "title", column = @Column(name = "book_title", nullable = false, updatable = false)),
    @AttributeOverride(name = "description", column = @Column(name = "book_description", length = 2000))
})
@NamedQueries(@NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b"))
public class Book extends Item {

    private static final long serialVersionUID = 1L;
    
    protected String publisher;

    protected String isbn;

    @Column(name = "nb_of_page", nullable = false)
    protected Integer nbOfPage;

    protected Boolean illustrations;
    
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "Tag")
    @Column(name = "Value")
    protected List<String> tags = new ArrayList<String>();

    // Constructors, getters, setters

    public Book() {
    }

    public Book(Long id) {
        this.id = id;
    }

    public Book(String title, Float price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

    public Boolean getIllustrations() {
        return illustrations;
    }

    public void setIllustrations(Boolean illustrations) {
        this.illustrations = illustrations;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Book{" 
                + "id=" + id 
                + ", title=" + title 
                + ", price=" + price 
                + ", description=" + description 
                + ", publisher=" + publisher 
                + ", isbn=" + isbn 
                + ", nbOfPage=" + nbOfPage 
                + ", illustrations=" + illustrations 
                + ", tags=" + tags 
                + '}';
    }
    
}
