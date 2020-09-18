/*
 * File:    MicroMarketFacade.java
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
import ru.lionsoft.javaee.helloea.ejb.model.entities.MicroMarket;
import ru.lionsoft.javaee.helloea.ejb.ws.rest.MicroMarketREST;
import ru.lionsoft.javaee.helloea.ejb.ws.soap.MicroMarketSOAP;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
@WebService(serviceName = "MicroMarketService", endpointInterface = "ru.lionsoft.javaee.ejb.ws.soap.MicroMarketSOAP")
public class MicroMarketFacade 
        extends AbstractFacade<MicroMarket> 
        implements MicroMarketSOAP, MicroMarketREST {

    public MicroMarketFacade() {
        super(MicroMarket.class);
    }
    
    // ************ Implements Interface WebService REST ***************

    @Override
    public void edit(String code, MicroMarket entity) {
        super.edit(entity);
    }

    @Override
    public void remove(String code) {
        super.remove(super.find(code));
    }

    @Override
    public MicroMarket find(String code) {
        return super.find(code);
    }

    @Override
    public List<MicroMarket> findRange(Integer from, Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @Override
    public String getCount() {
        return String.valueOf(super.count());
    }
}
