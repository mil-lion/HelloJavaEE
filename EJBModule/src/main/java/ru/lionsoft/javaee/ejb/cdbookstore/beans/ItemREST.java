/*
 * File:    ItemREST.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 12:35:53
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.beans;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ru.lionsoft.javaee.ejb.cdbookstore.entity.Book;
import ru.lionsoft.javaee.ejb.cdbookstore.entity.CD;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Path("/items")
public interface ItemREST {
 
    @GET
    @Path("books")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<Book> findBooks();

    @GET
    @Path("cds")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<CD> findCDs();
}
