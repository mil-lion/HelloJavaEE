/*
 * File:    Utilities.java
 * Project: Books
 * Date:    Jan 1, 2019 1:30:45 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.common;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class Utilities {

    public static Set<String> getSupportedLocales(HandleDefault defHandler) {
        Application app = FacesContext.getCurrentInstance().
                getApplication();
        Set<String> languageCodes = new HashSet<>();
        for (Iterator<Locale> itr = app.getSupportedLocales(); itr.hasNext();) {
            Locale locale = itr.next();
            languageCodes.add(locale.getLanguage());
        }

        String defaultLang = app.getDefaultLocale().getLanguage();
        if (defHandler == HandleDefault.Exclude) {
            languageCodes.remove(defaultLang);
        } else {
            languageCodes.add(defaultLang);
        }
        return languageCodes;
    }

    public enum HandleDefault {
        Include, Exclude
    }

    public static String getMessage(String key) {
        ResourceBundle messageBundle = ResourceBundle.getBundle("ru.lionsoft.javaee.jsf.books.messages");
        try {
            return messageBundle.getString(key);
        } catch (MissingResourceException e) {
            return "<unknown resource: " + key + ">";
        }
    }
}
