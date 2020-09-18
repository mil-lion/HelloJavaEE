/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.ejb.hello.ejb21;

import javax.ejb.EJBLocalObject;

/**
 * This is the HelloBean local interface.
 *
 * This interface is what local clients operate
 * on when they interact with EJB local objects.
 * The container vendor will implement this
 * interface; the implemented object is the
 * EJB local object, which delegates invocations
 * to the actual bean.
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public interface HelloLocal extends EJBLocalObject
{
    /**
     * The one method - hello - returns a greeting to the client.
     * 
     * @return hello string
     */
    public String hello();
}