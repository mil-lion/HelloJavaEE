/*
 * File:    DiscountCodeWebService.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:14:37
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.ws.soap;

import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;
import ru.lionsoft.javaee.ejb.model.entities.DiscountCode;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@WebService
public interface DiscountCodeWebService {

    void create(@WebParam(name = "entity") DiscountCode entity);

    void edit(@WebParam(name = "entity") DiscountCode entity);

    void remove(@WebParam(name = "entity") DiscountCode entity);

    DiscountCode find(@WebParam(name = "code") String code);

    List<DiscountCode> findAll();

    List<DiscountCode> findRange(@WebParam(name = "from") Integer from, @WebParam(name = "to") Integer to);

    int count();
    
}
