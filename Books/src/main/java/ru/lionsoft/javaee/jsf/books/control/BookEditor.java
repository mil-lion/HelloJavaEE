/*
 * File:    BookEditor.java
 * Project: Books
 * Date:    Jan 2, 2019 8:00:20 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.control;

import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Named
@ConversationScoped
public class BookEditor implements Serializable {
    
    public static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(BookEditor.class.getName());
    
    @Inject
    Conversation conversation;
    
    @PostConstruct
    private void init() {
        LOG.log(Level.INFO, "init in BookEditor");
        loadOrCreateBook();
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }
    
    private void loadOrCreateBook() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = fc.getExternalContext().getRequestParameterMap();
//        try {
//            int bookId = Integer.parseInt(paramMap.get("bookId"));
//            book = bookService.find(bookId);
//            if (book == null) {
//                book = new Book();
//            }
//        } catch (NumberFormatException e) {
//            book = new Book();
//        }
    }
    
    public void endConversation(Conversation conversation) {
        if (!conversation.isTransient()) {
            LOG.log(Level.INFO, "Conversation stopping: {0}", conversation.getId());
            conversation.end();
        }
    }
}
