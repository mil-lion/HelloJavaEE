/*
 * File:    ItemRemote.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 12:25:44
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.beans;

import java.util.List;
import javax.ejb.Local;
import ru.lionsoft.javaee.ejb.cdbookstore.entity.Book;
import ru.lionsoft.javaee.ejb.cdbookstore.entity.CD;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Local
public interface ItemRemote {

    List<Book> findBooks();

    List<CD> findCDs();

    Book createBook(Book book);

    CD createCD(CD cd);
}
