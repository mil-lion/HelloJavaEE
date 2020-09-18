/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.helloea.ejb.ws.soap;

import java.util.List;
import javax.jws.WebService;
import ru.lionsoft.javaee.helloea.ejb.model.entities.DiscountCode;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@WebService
public interface DiscountCodeSOAP {

//    @WebMethod
    void create(DiscountCode discountCode);

    void edit(DiscountCode discountCode);

    void remove(DiscountCode discountCode);

    DiscountCode find(Object id);

    List<DiscountCode> findAll();

    List<DiscountCode> findRange(int[] range);

    int count();
    
}
