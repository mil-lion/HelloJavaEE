/*
 * File:    CacheSingleton.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:10:48
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.singletone;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class CacheSingleton {

    private CacheSingleton() {
    }

    public static CacheSingleton getInstance() {
        return CacheSingletonHolder.INSTANCE;
    }

    private static class CacheSingletonHolder {

        private static final CacheSingleton INSTANCE = new CacheSingleton();
    }

    // Business Logic
    private final Map<Long, Object> cache = new HashMap<>();

    public synchronized void addToCache(Long id, Object object) {
        if (!cache.containsKey(id)) {
            cache.put(id, object);
        }
    }

    public synchronized void removeFromCache(Long id) {
        if (cache.containsKey(id)) {
            cache.remove(id);
        }
    }

    public Object getFromCache(Long id) {
        if (cache.containsKey(id)) {
            return cache.get(id);
        } else {
            return null;
        }
    }
}
