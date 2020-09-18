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
import ru.lionsoft.javaee.helloea.ejb.model.entities.Customer;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Path("customer")
public interface CustomerREST {

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void create(Customer entity);

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void edit(@PathParam("id") Integer id, Customer entity);

    @DELETE
    @Path("{id}")
    void remove(@PathParam("id") Integer id);

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Customer find(@PathParam("id") Integer id);

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<Customer> findAll();

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<Customer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to);

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    String getCount();
    
}
