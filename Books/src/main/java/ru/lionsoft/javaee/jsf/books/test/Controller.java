/*
 * File:    Controller.java
 * Project: Books
 * Date:    Jan 3, 2019 12:34:48 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.test;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Named
@RequestScoped
public class Controller {

    private int counter;

    public int getCounter() {
        return counter;
    }

    private List<Friend> friends;
    
    public List<Friend> getFriends() {
        counter++;
        if (friends == null) {
            friends = DataProvider.instance.getFriends();
        }
        return friends;
    }
}
