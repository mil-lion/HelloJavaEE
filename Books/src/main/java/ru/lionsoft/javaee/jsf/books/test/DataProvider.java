/*
 * File:    DataProvider.java
 * Project: Books
 * Date:    Jan 3, 2019 12:36:05 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class DataProvider {

    private final List<Friend> friends = new ArrayList<>();

    public static DataProvider instance = new DataProvider();

    private DataProvider() {
        createData();
    }

    /**
     * retrieves a list of friends
     *
     * @return friends
     */
    public List<Friend> getFriends() {
        retrieveDatafromDB();
        return friends;
    }

    private void retrieveDatafromDB() {
        // here might be an access to a DB
        // simulate it by a sleep (yea, shouldn't use sleep in an EE environment)
        try {
            Thread.sleep(100); // slow db access
        } catch (InterruptedException ex) {
            // ignore
        }
    }

    private void createData() {
        friends.clear();
        String[] names = {"Sally", "Bob", "John", "Mary", "Jim"};
        for (int i = 0; i < 5; i++) {
            addFriend(names[i]);
        }
    }

    private void addFriend(String name) {
        Friend friend = new Friend(name);
        Random random = new Random();
        int count = random.nextInt(5);
        for (int i = 0; i < count; i++) {
            String title = "Book." + name.substring(0, 1) + i;
            Book book = new Book(title);
            friend.getBooks().add(book);
        }
        friends.add(friend);
    }
}
