/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.ejb.model.facades;

import java.util.List;
import javax.ejb.Local;
import ru.lionsoft.javaee.ejb.model.entities.DiscountCode;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Local
public interface DiscountCodeFacadeLocal {

    void create(DiscountCode discountCode);

    void edit(DiscountCode discountCode);

    void remove(DiscountCode discountCode);

    DiscountCode find(Object id);

    List<DiscountCode> findAll();

    List<DiscountCode> findRange(int[] range);

    int count();
    
}
