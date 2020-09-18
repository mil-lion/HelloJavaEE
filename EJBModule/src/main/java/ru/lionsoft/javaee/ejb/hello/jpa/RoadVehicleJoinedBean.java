/*
 * File:    RoadVehicleJoinedBean.java
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
import ru.lionsoft.javaee.ejb.hello.entity.joined.Coupe;
import ru.lionsoft.javaee.ejb.hello.entity.joined.Motorcycle;
import ru.lionsoft.javaee.ejb.hello.entity.joined.RoadVehicle;
import ru.lionsoft.javaee.ejb.hello.entity.joined.Roadster;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
public class RoadVehicleJoinedBean implements RoadVehicleJoined {
    
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
    public List<RoadVehicle> getAllRoadVehicles() {
        Query q = em.createQuery("SELECT r FROM RoadVehicleJoined r");
        return q.getResultList();
    }
}
