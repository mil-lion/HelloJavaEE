/*
 * File:    RoadVehicleJoined.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:07:06
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import java.util.List;
import javax.ejb.Remote;
import ru.lionsoft.javaee.ejb.hello.entity.joined.RoadVehicle;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Remote
public interface RoadVehicleJoined {

    void doSomeStuff();

    List<RoadVehicle> getAllRoadVehicles();
    
}
