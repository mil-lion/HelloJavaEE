/*
 * File:    JDBCConnectionProducer.java
 * Project: HelloCDI
 * Date:    25 дек. 2018 г. 10:04:38
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.producers;

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

//    private static final String JDBC_DRIVER_CLASS = "org.apache.derby.jdbc.EmbeddedDriver";
//    private static final String JDBC_URL = "jdbc:derby:memory:test";
    private static final String JDBC_DRIVER_CLASS = "org.apache.derby.jdbc.ClientDriver";
    private static final String JDBC_URL = "jdbc:derby://localhost:1527/sample";

    /**
     * Производитель данных соединения с СУБД
     * 
     * @return соединение с БД
     */
    @Produces
    private Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER_CLASS).newInstance();
            conn = DriverManager.getConnection(JDBC_URL, "app", "app");
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Утилизатор данных соединения с СУБД
     * 
     * @param conn соединение с БД
     * @throws SQLException ошибка SQL
     */
    private void closeConnection(@Disposes Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
