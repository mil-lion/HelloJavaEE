/*
 * File:    ItemTablePerClassBean.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:45:25
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ru.lionsoft.javaee.ejb.hello.entity.table_per_class.Book;
import ru.lionsoft.javaee.ejb.hello.entity.table_per_class.CD;
import ru.lionsoft.javaee.ejb.hello.entity.table_per_class.Item;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
public class ItemTablePerClassBean implements ItemTablePerClass {
    
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;
    
    @Override
    public void doSomeStuff() {
        Book book = new Book();
        book.setTitle("The Hitchhiker's Guide to the Galaxy"); book.setPrice(12.5F);
        book.setDescription("Science fiction comedy series created by Douglas Adams.");
        book.setIsbn("1-84023-742-2");
        book.setNbOfPage(354);
        book.setIllustrations(false);
        em.persist(book);
//        statefulComponent.addBookToShoppingCart(book);

        book = new Book();
        book.setTitle("The Robots of Dawn");
        book.setPrice(18.25f);
        book.setDescription("Isaac Asimov's Robot Series");
        book.setIsbn("0-553-29949-2");
        book.setNbOfPage(276);
        book.setIllustrations(false);
        em.persist(book);
//        statefulComponent.addBookToShoppingCart( book);

//        statefulComponent.checkOutShoppingCart();

        CD cd = new CD();
        cd.setTitle("");
        cd.setPrice(12.5f);
        cd.setDescription("");
        cd.setMusicCompany("");
        cd.setNumberOfCDs(2);
        cd.setTotalDuration(60.0);
        em.persist(cd);
    }
    
    @Override
    public List<Item> getAllItems() {
        Query q = em.createQuery("SELECT i FROM Item i");
        return q.getResultList();
    }

}
