/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.helloea.ejb.ws.soap;

import java.util.List;
import javax.jws.WebService;
import ru.lionsoft.javaee.helloea.ejb.model.entities.MicroMarket;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@WebService
public interface MicroMarketSOAP {

    void create(MicroMarket microMarket);

    void edit(MicroMarket microMarket);

    void remove(MicroMarket microMarket);

    MicroMarket find(Object id);

    List<MicroMarket> findAll();

    List<MicroMarket> findRange(int[] range);

    int count();
    
}
