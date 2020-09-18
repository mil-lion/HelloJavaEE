/*
 * File:    MicroMarketREST.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:14:37
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.ws.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ru.lionsoft.javaee.ejb.model.entities.MicroMarket;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Path("microMarket")
public interface MicroMarketREST {

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void create(MicroMarket microMarket);

    @PUT
    @Path("{code}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void edit(@PathParam("code") String code, MicroMarket microMarket);

    @DELETE
    @Path("{code}")
    void remove(@PathParam("code") String code);

    @GET
    @Path("{code}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    MicroMarket find(@PathParam("code") String code);

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<MicroMarket> findAll();

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<MicroMarket> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to);

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    String getCount();
    
}
