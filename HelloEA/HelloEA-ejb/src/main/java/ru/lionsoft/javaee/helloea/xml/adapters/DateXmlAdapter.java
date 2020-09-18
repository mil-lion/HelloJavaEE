/*
 * File:    DateXmlAdapter.java
 * Project: HelloEA-ejb
 * Date:    24 дек. 2018 г. 13:06:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.helloea.xml.adapters;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class DateXmlAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    
    @Override
    public Date unmarshal(String vt) throws Exception {
        return dateFormat.parse(vt);
    }

    @Override
    public String marshal(Date bt) throws Exception {
        return dateFormat.format(bt);
    }
    
}
