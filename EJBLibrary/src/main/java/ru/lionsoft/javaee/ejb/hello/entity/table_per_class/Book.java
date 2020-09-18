/*
 * File:    Book.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 22:48:07
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity.table_per_class;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity(name = "BookItem")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "book_id")),
    @AttributeOverride(name = "title", column = @Column(name = "book_title")),
    @AttributeOverride(name = "description", column = @Column(name = "book_description"))
})
public class Book extends Item {

    private static final long serialVersionUID = 1L;

    protected String isbn;
    
    protected String publisher;
    
    protected Integer nbOfPage;
    
    protected Boolean illustrations;

    // Constructors

    public Book() {
        super();
    }

    public Book(Long id) {
        super(id);
    }
    
    // Getters, setters

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
                + '}';
    }

    
}
