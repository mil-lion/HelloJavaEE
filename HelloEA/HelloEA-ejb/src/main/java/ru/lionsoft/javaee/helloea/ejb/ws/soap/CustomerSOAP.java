/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.helloea.ejb.ws.soap;

import java.util.List;
import javax.jws.WebService;
import ru.lionsoft.javaee.helloea.ejb.model.entities.Customer;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@WebService
public interface CustomerSOAP {

    void create(Customer customer);

    void edit(Customer customer);

    void remove(Customer customer);

    Customer find(Object id);

    List<Customer> findAll();

    List<Customer> findRange(int[] range);

    int count();
    
}
