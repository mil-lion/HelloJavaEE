/*
 * File:    DiscountCodeFacade.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:03:54
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.model.facades;

import java.util.List;
import javax.ejb.Remote;
import ru.lionsoft.javaee.ejb.model.entities.DiscountCode;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Remote
public interface DiscountCodeFacade {

    void create(DiscountCode discountCode);

    void edit(DiscountCode discountCode);

    void remove(DiscountCode discountCode);

    DiscountCode find(Object id);

    List<DiscountCode> findAll();

    List<DiscountCode> findRange(int[] range);

    int count();
    
}
