/*
 * File:    CustomerFacade.java
 * Project: HelloEA-ejb
 * Date:    24 дек. 2018 г. 13:06:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.helloea.ejb.model.facades;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import ru.lionsoft.javaee.helloea.ejb.model.entities.Customer;
import ru.lionsoft.javaee.helloea.ejb.ws.rest.CustomerREST;
import ru.lionsoft.javaee.helloea.ejb.ws.soap.CustomerSOAP;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
@LocalBean
@WebService(serviceName = "CustomerService", endpointInterface = "ru.lionsoft.javaee.ejb.ws.soap.CustomerWebService")
public class CustomerFacade 
        extends AbstractFacade<Customer> 
        implements CustomerSOAP, CustomerREST {

    public CustomerFacade() {
        super(Customer.class);
    }

    // ************ Implements Interface WebService REST ***************

    @Override
    public void edit(Integer id, Customer entity) {
        super.edit(entity);
    }

    @Override
    public void remove(Integer id) {
        super.remove(super.find(id));
    }

    @Override
    public Customer find(Integer id) {
        return super.find(id);
    }

    @Override
    public List<Customer> findRange(Integer from, Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @Override
    public String getCount() {
        return String.valueOf(super.count());
    }
    
}
