/*
 * File:    MicroMarketFacade.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:03:54
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.model.facades;

import java.util.List;
import javax.ejb.Remote;
import ru.lionsoft.javaee.ejb.model.entities.MicroMarket;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Remote
public interface MicroMarketFacade {

    void create(MicroMarket microMarket);

    void edit(MicroMarket microMarket);

    void remove(MicroMarket microMarket);

    MicroMarket find(Object id);

    List<MicroMarket> findAll();

    List<MicroMarket> findRange(int[] range);

    int count();
    
}
