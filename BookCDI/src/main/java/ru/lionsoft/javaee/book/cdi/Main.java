/*
 * File:    Main.java
 * Project: BookCDI
 * Date:    Jan 5, 2019 4:45:35 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.book.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class Main {
    
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        
        BookService bookService = container.select(BookService.class).get();
        
        Book book = bookService.createBook("H2G2", 12.f, "Интересная книга на тему высоких технологий");
        
        System.out.println(book);
        
        weld.shutdown();
    }
}
