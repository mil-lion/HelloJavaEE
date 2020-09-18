/*
 * File:    CustomerService.java
 * Project: EJBModule
 * Date:    25 дек. 2018 г. 13:08:50
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import ru.lionsoft.javaee.ejb.hello.entity.Customer;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Transactional
public class CustomerService {

    @Inject
    private EntityManager em;
    
    @Inject
    private Logger logger;

    public void createCustomer(Customer customer) {
        em.persist(customer);
    }

    public Customer findCustomerById(Long id) {
        return em.find(Customer.class, id);
    }

    @AroundInvoke
    private Object logMethod(InvocationContext ic) throws Exception {
        logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
        }
    }
}
