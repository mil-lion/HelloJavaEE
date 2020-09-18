/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.ejb.hello.entity.mapped_superclass;

import javax.persistence.Entity;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
public class Motorcycle extends RoadVehicle {
  
    public final AcceleratorType acceleratorType = AcceleratorType.THROTTLE;

    public Motorcycle() {
        super();
        numWheels = 2;
        numPassengers = 2;
    }
    
    @Override
    public String toString() {
        return "Motorcycle::" + super.toString();
    }
}
