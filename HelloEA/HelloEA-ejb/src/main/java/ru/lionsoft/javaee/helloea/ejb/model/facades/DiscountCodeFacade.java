/*
 * File:    DiscountCodeFacade.java
 * Project: HelloEA-ejb
 * Date:    24 дек. 2018 г. 13:06:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.helloea.ejb.model.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebService;
import ru.lionsoft.javaee.helloea.ejb.model.entities.DiscountCode;
import ru.lionsoft.javaee.helloea.ejb.ws.rest.DiscountCodeREST;
import ru.lionsoft.javaee.helloea.ejb.ws.soap.DiscountCodeSOAP;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
@WebService(serviceName = "DiscountCodeService", endpointInterface = "ru.lionsoft.javaee.ejb.ws.soap.DiscountCodeSOAP")
public class DiscountCodeFacade 
        extends AbstractFacade<DiscountCode> 
        implements DiscountCodeSOAP, DiscountCodeREST {

    public DiscountCodeFacade() {
        super(DiscountCode.class);
    }
    
    // ************ Implements Interface WebService REST ***************

    @Override
    public void edit(String code, DiscountCode entity) {
        super.edit(entity);
    }

    @Override
    public void remove(String code) {
        super.remove(super.find(code));
    }

    @Override
    public DiscountCode find(String code) {
        return super.find(code);
    }

    @Override
    public List<DiscountCode> findRange(Integer from, Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @Override
    public String getCount() {
        return String.valueOf(super.count());
    }
    
}
