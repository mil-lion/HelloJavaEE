/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.xml.adapters;

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
