/*
 * File:    HelloHome.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 17:56:47
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.ejb21;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
* This is the home interface for HelloBean. This interface
 * is implemented by the EJB Server’s tools - the
 * implemented object is called the Home Object, and serves
 * as a factory for EJB Objects.
 *
 * One create() method is in this Home Interface, which
 * corresponds to the ejbCreate() method in HelloBean.
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public interface HelloHome extends EJBHome
{
    /**
     * This method creates the EJB Object.
     *
     * @return The newly created EJB Object.
     * @throws java.rmi.RemoteException
     * @throws javax.ejb.CreateException
     */
    Hello create() throws RemoteException, CreateException;
}