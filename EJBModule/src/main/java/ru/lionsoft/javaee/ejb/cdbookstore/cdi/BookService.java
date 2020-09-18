/*
 * File:    BookService.java
 * Project: EJBModule
 * Date:    25 дек. 2018 г. 0:56:13
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import ru.lionsoft.javaee.ejb.cdbookstore.entity.Book;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class BookService {

    @Inject 
//    @ThirteenDigits
    @NumberOfDigits(value = Digits.THIRTEEN, odd = false)
    private NumberGenerator numberGenerator;
    
    @Inject
    private EntityManager em;
    
    private Date instanciationDate;

    @PostConstruct
    private void initDate() {
        instanciationDate = new Date();
    }

    @Transactional
    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description);
        book.setIsbn(numberGenerator.generateNumber());
//        book.setInstanciationDate(instanciationDate);
        em.persist(book);
        return book;
    }
}
