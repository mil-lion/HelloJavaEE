/*
 * File:    Book.java
 * Project: Books
 * Date:    Jan 3, 2019 12:41:58 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.test;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class Book {
    
    private int id = -1;
    
    private String title;

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

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + '}';
    }

    
}
