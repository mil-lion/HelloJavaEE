/*
 * File:    StatisticsEJB.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 13:13:00
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.timer;

import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
public class StatisticsEJB {

    @Schedule(dayOfMonth = "1", hour = "5", minute = "30")
    public void statisticsItemsSold() {
        // ...
    }

    @Schedules({
        @Schedule(hour = "2"),
        @Schedule(hour = "14", dayOfWeek = "Wed")
    })
    public void generateReport() {
        // ...
    }

    @Schedule(minute = "*/10", hour = "*", persistent = false)
    public void refreshCache() {
        // ...
    }
}
