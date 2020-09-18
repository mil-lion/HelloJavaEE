/*
 * File:    JDBCConnectionProducer.java
 * Project: EJBModule
 * Date:    25 дек. 2018 г. 10:04:38
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class JDBCConnectionProducer {

    @Produces
    private Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:derby:memory:test", "APP", "APP");
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private void closeConnection(@Disposes Connection conn) throws SQLException {
        conn.close();
    }
}
