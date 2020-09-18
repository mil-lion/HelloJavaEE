/*
 * File:    RoadVehicleMappedSuperclass.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:07:06
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import java.util.List;
import javax.ejb.Remote;
import ru.lionsoft.javaee.ejb.hello.entity.mapped_superclass.Car;
import ru.lionsoft.javaee.ejb.hello.entity.mapped_superclass.Coupe;
import ru.lionsoft.javaee.ejb.hello.entity.mapped_superclass.Motorcycle;
import ru.lionsoft.javaee.ejb.hello.entity.mapped_superclass.Roadster;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Remote
public interface RoadVehicleMappedSuperclass {

    void doSomeStuff();

    List<Car> getAllCars();

    List<Coupe> getAllCoupes();

    List<Motorcycle> getAllMotorcycles();

    List<Roadster> getAllRoadsters();
    
}
