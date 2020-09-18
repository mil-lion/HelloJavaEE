/*
 * File:    CacheEJB.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:14:37
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.singletone;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Singleton
@Startup
@DependsOn({"CountryCodeEJB", "ZipCodeEJB"})
//@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(LockType.WRITE)
@AccessTimeout(value = 20, unit = TimeUnit.SECONDS)
public class CacheEJB {
    
    private final Map<Long, Object> cache = new HashMap<>();

    @PostConstruct
    private void initCache() {
        // Initializes the cache
        System.out.println("Initializes the cache");
    }

    @AccessTimeout(0)
    public void addToCache(Long id, Object object) {
        if (!cache.containsKey(id)) {
            cache.put(id, object);
        }
    }

    public void removeFromCache(Long id) {
        if (cache.containsKey(id)) {
            cache.remove(id);
        }
    }

    @Lock(LockType.READ)
    public Object getFromCache(Long id) {
        if (cache.containsKey(id)) {
            return cache.get(id);
        } else {
            return null;
        }
    }
}
