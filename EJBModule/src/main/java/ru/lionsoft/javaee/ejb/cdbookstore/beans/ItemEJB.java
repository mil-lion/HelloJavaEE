/*
 * File:    ItemEJB.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:03:54
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.beans;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ru.lionsoft.javaee.ejb.cdbookstore.entity.Book;
import ru.lionsoft.javaee.ejb.cdbookstore.entity.CD;
import ru.lionsoft.javaee.ejb.cdbookstore.entity.Item;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
//@Local(ItemLocal.class)
//@Remote(ItemRemote.class)
//@LocalBean
@WebService(serviceName = "ItemService", endpointInterface = "ru.lionsoft.javaee.ejb.cdbookstore.beans.ItemSOAP")
public class ItemEJB implements ItemLocal, ItemRemote, ItemSOAP, ItemREST {
    
    @Resource
    private SessionContext context;
    
    // or
    //@Resource
    public void setContext(SessionContext context) {
        this.context = context;
    }
    
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;
        
    @Override
    public List<Book> findBooks() {
        TypedQuery<Book> query = em.createNamedQuery("findAllBooks", Book.class);
        return query.getResultList();
    }
    
    @Override
    public List<CD> findCDs() {
        TypedQuery<CD> query = em.createNamedQuery("findAllCDs", CD.class);
        return query.getResultList();
    }
    
    @Override
    public Book createBook(Book book) {
        em.persist(book);
        
//        if (cantFindAuthor())
//            context.setRollbackOnly();
        
        return book;
    }
    
    @Override
    public CD createCD(CD cd) {
        em.persist(cd);
        return cd;
    }

    // Dependency Injection
    
//    @EJB
//    private CustomerEJB customerEJB;
    
//    @WebServiceRef
//    private ArtistWebService artistWebService;
    
    // Environment Naming Context
    
    @Resource(name = "currencyEntry")
    private String currency;
    
    @Resource(name = "changeRateEntry")
    private Float changeRate;
    
    public Item convertPrice(Item item) {
        item.setPrice(item.getPrice() * changeRate);
        item.setCurrency(currency);
        return item;
    }
 
}
