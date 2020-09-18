/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.ejb.hello.entity.mapped_superclass;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class Car extends RoadVehicle {
  
    public final AcceleratorType acceleratorType = AcceleratorType.PEDAL;

    public Car() {
        super();
        numWheels = 4;
    }
    
    @Override
    public String toString() {
        return "Car::" + super.toString();
    }
}
