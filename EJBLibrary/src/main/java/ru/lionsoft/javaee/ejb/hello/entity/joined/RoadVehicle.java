/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.ejb.hello.entity.joined;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity(name = "RoadVehicleJoined")
@Table(name = "ROADVEHICLEJOINED")
@Inheritance(strategy = InheritanceType.JOINED)
public class RoadVehicle implements Serializable {
    
    public enum AcceleratorType {PEDAL, THROTTLE};
    
    @Id
    protected int id;
    protected int numPassengers;
    protected int numWheels;
    protected String make;
    protected String model;

    public RoadVehicle() {
        id = (int) System.nanoTime();
    }

    // setters and getters go here

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "RoadVehicle{" + "numPassengers=" + numPassengers + ", numWheels=" + numWheels + ", make=" + make + ", model=" + model + '}';
    }
    
}
