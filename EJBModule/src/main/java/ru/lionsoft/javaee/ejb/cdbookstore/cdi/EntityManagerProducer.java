/*
 * File:    EntityManagerProducer.java
 * Project: EJBModule
 * Date:    26 дек. 2018 г. 23:16:51
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@RequestScoped
public class EntityManagerProducer {
    
    @Produces @SamplePU
    @PersistenceContext(unitName = "SamplePU")
    private EntityManager em1;
    
    @Produces @TestPU
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em2;
    
}
