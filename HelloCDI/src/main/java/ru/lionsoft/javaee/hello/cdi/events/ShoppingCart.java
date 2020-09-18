/*
 * File:    ShoppingCart.java
 * Project: HelloCDI
 * Date:    Jan 8, 2019 10:53:08 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.events;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@SessionScoped
public class ShoppingCart implements Serializable {
    
    private final List<Wine> wines = new ArrayList<>();

    public List<Wine> getWines() {
        return wines;
    }
    
    public void addWine(@Observes @Added Wine wine) {
        wines.add(wine);
    }
    
    public void deleteWine(@Observes @Removed Wine wine) {
        wines.remove(wine);
    }
    
    public void clear() {
        wines.clear();
    }
}
