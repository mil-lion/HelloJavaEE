/*
 * File:    RoadVehicleMappedSuperclassBean.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:45:25
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ru.lionsoft.javaee.ejb.hello.entity.mapped_superclass.Car;
import ru.lionsoft.javaee.ejb.hello.entity.mapped_superclass.Coupe;
import ru.lionsoft.javaee.ejb.hello.entity.mapped_superclass.Motorcycle;
import ru.lionsoft.javaee.ejb.hello.entity.mapped_superclass.Roadster;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
public class RoadVehicleMappedSuperclassBean implements RoadVehicleMappedSuperclass {
    
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;
    
    @Override
    public void doSomeStuff() {
        Coupe c = new Coupe();
        c.setMake("Bob");
        c.setModel("E400");
        c.setBoringFactor(Coupe.BoringFactor.BORING);
        em.persist(c);
        
        Roadster r = new Roadster();
        r.setMake("Mini");
        r.setModel("Cooper S");
        r.setCoolFactor(Roadster.CoolFactor.COOLEST);
        em.persist(r);
        
        Motorcycle m = new Motorcycle();
        em.persist(m);
    }
    
    @Override
    public List<Motorcycle> getAllMotorcycles() {
        Query query = em.createQuery("SELECT m FROM Motorcycle m");
        return query.getResultList();
    }

    @Override
    public List<Car> getAllCars() {
        Query query = em.createQuery("SELECT * FROM Coupe c FULL JOIN Roadster r");
        return query.getResultList();
    }

    @Override
    public List<Coupe> getAllCoupes() {
        Query query = em.createQuery("SELECT c FROM Car c");
        return query.getResultList();
    }

    @Override
    public List<Roadster> getAllRoadsters() {
        Query query = em.createQuery("SELECT r FROM Roadster r");
        return query.getResultList();
    }
}
