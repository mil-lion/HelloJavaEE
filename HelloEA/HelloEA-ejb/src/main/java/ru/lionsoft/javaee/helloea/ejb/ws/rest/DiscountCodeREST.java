/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.helloea.ejb.ws.rest;

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
import ru.lionsoft.javaee.helloea.ejb.model.entities.DiscountCode;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Path("discountCode")
public interface DiscountCodeREST {

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void create(DiscountCode enity);

    @PUT
    @Path("{code}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void edit(@PathParam("code") String code, DiscountCode entity);

    @DELETE
    @Path("{code}")
    void remove(@PathParam("code") String code);

    @GET
    @Path("{code}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    DiscountCode find(@PathParam("code") String code);

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<DiscountCode> findAll();

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<DiscountCode> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to);

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    String getCount();
    
}
