/*
 * File:    ShoppingCartEJB.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:03:54
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.stateful;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import ru.lionsoft.javaee.ejb.hello.entity.table_per_class.Item;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateful
//@Stateful(passivationCapable = false)
@StatefulTimeout(value = 20, unit = TimeUnit.SECONDS)
@LocalBean
public class ShoppingCartEJB {

    // State variables
    private final List<Item> cartItems = new ArrayList<>();

    // Business methods
    public void addItem(Item item) {
        if (!cartItems.contains(item)) {
            cartItems.add(item);
        }
    }

    public void removeItem(Item item) {
        if (cartItems.contains(item)) {
            cartItems.remove(item);
        }
    }

    public Integer getNumberOfItems() {
        if (cartItems == null || cartItems.isEmpty()) {
            return 0;
        }
        return cartItems.size();
    }

    public Float getTotal() {
        if (cartItems == null || cartItems.isEmpty()) {
            return 0f;
        }
        Float total = 0f;
        for (Item cartItem : cartItems) {
            total += (cartItem.getPrice());
        }
        return total;
    }

    public void empty() {
        cartItems.clear();
    }

    @Remove
    public void checkout() {
        // Do some business logic
        cartItems.clear();
    }
}
