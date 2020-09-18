/*
 * File:    BookServiceIT.java
 * Project: BookCDI
 * Date:    Jan 5, 2019 4:51:55 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.book.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class BookServiceIT {

    public BookServiceIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldCheckNumberIsMOCK() {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        
        BookService bookService = container.instance().select(BookService.class).get();
        
        Book book = bookService.createBook("H2G2", 12.5f, "Интересная книга на тему высоких технологий");
        
        assertTrue(book.getNumber().startsWith("MOCK"));
        
        weld.shutdown();
    }
}
