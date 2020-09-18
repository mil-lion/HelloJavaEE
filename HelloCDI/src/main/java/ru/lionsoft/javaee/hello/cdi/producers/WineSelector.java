/*
 * File:    WineSelector.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 10:04:15 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.producers;

import java.util.Random;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class WineSelector {
    
    @Produces
    @RandomSelector
    public Wine getWine(
            @New ShardonnayWine whiteWine, 
            @New CabernetWine redWine, 
            @New MerlotWine roseWine, 
            @New ChampagneWine sparklingWine) {
        final int wineNumber = new Random().nextInt(4);
        switch (wineNumber) {
            case 0:
                return whiteWine;
            case 1:
                return redWine;
            case 2:
                return roseWine;
            case 3:
                return sparklingWine;
            default:
                return null;
        }
    }
}
