/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.ejb.model.facades;

import java.util.List;
import javax.ejb.Local;
import ru.lionsoft.javaee.ejb.model.entities.MicroMarket;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Local
public interface MicroMarketFacadeLocal {

    void create(MicroMarket microMarket);

    void edit(MicroMarket microMarket);

    void remove(MicroMarket microMarket);

    MicroMarket find(Object id);

    List<MicroMarket> findAll();

    List<MicroMarket> findRange(int[] range);

    int count();
    
}
