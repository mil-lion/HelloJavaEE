/*
 * File:    Friend.java
 * Project: Books
 * Date:    Jan 3, 2019 12:39:09 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class Friend {

    private final String name;
    
    private final List<Book> books = new ArrayList<>();

    
    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
