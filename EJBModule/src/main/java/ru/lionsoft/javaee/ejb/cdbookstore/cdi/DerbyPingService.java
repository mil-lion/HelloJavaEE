/*
 * File:    DerbyPingService.java
 * Project: EJBModule
 * Date:    25 дек. 2018 г. 12:44:11
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import java.sql.Connection;
import java.sql.SQLException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@ApplicationScoped
public class DerbyPingService {
    
    @Inject
    private Connection conn;
    
    public void ping() throws SQLException {
        conn.createStatement().executeQuery("SELECT 1 FROM SYSIBM.SYSDUMMY1");
    }
}
