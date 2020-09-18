/*
 * File:    SessionTools.java
 * Project: Books
 * Date:    Dec 31, 2018 7:17:08 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.control;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Named
@SessionScoped
public class SessionTools implements Serializable {

    private static final long serialVersionUID = 1L;

    public String getLanguageCode() {
        return "en";
    }

    public String getMessage(String key) {
        ResourceBundle messageBundle;
        Locale locale = new Locale(getLanguageCode());
        messageBundle = ResourceBundle.getBundle("ru.lionsoft.javaee.jsf.books.messages", locale);
        return messageBundle.getString(key);
    }

    public void preRenderView(ComponentSystemEvent event) {
        Locale locale = new Locale(getLanguageCode());
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}
