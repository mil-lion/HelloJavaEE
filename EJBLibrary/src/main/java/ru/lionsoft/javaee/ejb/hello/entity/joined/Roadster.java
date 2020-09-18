/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.ejb.hello.entity.joined;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class Roadster extends Car {

    public enum CoolFactor {COOL, COOLER, COOLEST};
    
    private CoolFactor coolFactor;
    
    public Roadster() {
        super();
        numPassengers = 2;
    }
    
    // setters and getters go here

    public CoolFactor getCoolFactor() {
        return coolFactor;
    }

    public void setCoolFactor(CoolFactor coolFactor) {
        this.coolFactor = coolFactor;
    }

    @Override
    public String toString() {
        return "Roadster::" + super.toString();
    }    
}
