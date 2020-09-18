/*
 * File:    CustomerFacade.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:03:54
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.model.facades;

import java.util.List;
import javax.ejb.Remote;
import ru.lionsoft.javaee.ejb.model.entities.Customer;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Remote
public interface CustomerFacade {

    void create(Customer customer);

    void edit(Customer customer);

    void remove(Customer customer);

    Customer find(Object id);

    List<Customer> findAll();

    List<Customer> findRange(int[] range);

    int count();
    
}
