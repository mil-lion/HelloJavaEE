/*
 * File:    BookService.java
 * Project: BookCDI
 * Date:    Jan 5, 2019 4:45:49 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.book.cdi;

import javax.inject.Inject;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Loggable
public class BookService {
    
    @Inject @ThirteenDigits
    private NumberGenerator numberGenerator;
    
    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        return book;
    }
}
