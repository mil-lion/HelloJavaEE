/*
 * File:    ItemSOAP.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 12:30:23
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.beans;

import java.util.List;
import javax.jws.WebService;
import ru.lionsoft.javaee.ejb.cdbookstore.entity.Book;
import ru.lionsoft.javaee.ejb.cdbookstore.entity.CD;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@WebService
public interface ItemSOAP {
    
    List<Book> findBooks();

    List<CD> findCDs();
}
