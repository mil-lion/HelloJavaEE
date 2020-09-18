/*
 * File:    LegacyBookService.java
 * Project: EJBModule
 * Date:    25 дек. 2018 г. 1:13:47
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import javax.inject.Inject;
import ru.lionsoft.javaee.ejb.cdbookstore.entity.Book;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class LegacyBookService {

    @Inject
    @EightDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description);
        book.setIsbn(numberGenerator.generateNumber());
        return book;
    }

}
