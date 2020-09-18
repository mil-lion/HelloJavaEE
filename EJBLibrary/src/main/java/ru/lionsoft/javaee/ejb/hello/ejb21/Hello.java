/*
 * File:    Hello.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 17:56:47
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.ejb21;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

/**
 * This is the HelloBean remote interface.
 *
 * This interface is what clients operate on when
 * they interact with EJB objects. The container
 * vendor will implement this interface; the
 * implemented object is the EJB object, which
 * delegates invocations to the actual bean.
 * 
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public interface Hello extends EJBObject
{
    /**
     * The one method - hello - returns a greeting to the client.
     * 
     * @return hello string
     * @throws java.rmi.RemoteException
     */
    public String hello() throws RemoteException;
}