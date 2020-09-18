/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.ejb.hello.entity.single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
@DiscriminatorValue("COUPE")
public class Coupe extends Car {
    
    public enum BoringFactor {BORING, BORINGER, BORINGEST};
    
    private BoringFactor boringFactor;
    
    public Coupe() {
        numPassengers = 5;
    }
    
    // setters and getters go here

    public BoringFactor getBoringFactor() {
        return boringFactor;
    }

    public void setBoringFactor(BoringFactor boringFactor) {
        this.boringFactor = boringFactor;
    }

    @Override
    public String toString() {
        return "Coupe::" + super.toString();
    }
    
}
