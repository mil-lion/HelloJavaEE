/*
 * File:    CustomerWebService.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:14:37
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.ws.soap;

import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;
import ru.lionsoft.javaee.ejb.model.entities.Customer;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@WebService
public interface CustomerWebService {

    void create(@WebParam(name = "entity") Customer entity);

    void edit(@WebParam(name = "entity") Customer entity);

    void remove(@WebParam(name = "entity") Customer entity);

    Customer find(@WebParam(name = "id") Integer id);

    List<Customer> findAll();

    List<Customer> findRange(@WebParam(name = "from") Integer from, @WebParam(name = "to") Integer to);

    int count();
    
}
