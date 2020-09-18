/*
 * File:    RoadVehicleClient.java
 * Project: EJBClient
 * Date:    23 дек. 2018 г. 22:19:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.jpa.joined;

import javax.ejb.EJB;
import ru.lionsoft.javaee.ejb.hello.jpa.RoadVehicleJoined;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class RoadVehicleClient {
    
    @EJB
    private static RoadVehicleJoined rvs;
    
    public static void main(String[] args) {
        rvs.doSomeStuff();
        for (Object rv : rvs.getAllRoadVehicles()) {
            System.out.println("RoadVehicle: " + rv);
        }
    }
}
