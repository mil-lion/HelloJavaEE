/*
 * File:    WineProducerClient.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 9:48:47 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.producers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@WebServlet(name = "WineProducerClient", urlPatterns = {"/WineProducerClient"})
public class WineProducerClient extends HttpServlet {

    // Instantiating via field dependency injection
    @Inject 
    @RandomSelector
    private Wine randomWine;

    // Test LoggingProducer
    @Inject
    private Logger logger;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("WineProducerClient::processRequest called!");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WineProducerClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WineProducerClient at <a href='" + request.getContextPath() + "'>" 
                    + request.getContextPath() + "<a></h1>");
            out.println("<h2>Re-deploy and run this servlet couple of times to see the random change in wine color: " + randomWine.getName() + "::" + randomWine.getColor() + " (<i>" + randomWine + "</i>)</h2>");
            out.println("<h4>(Make sure the page is not cached. Try redeploying the project itself.)</h4>");
            out.println("<h2>Ping to RDBMS: " + ping() + "</h2>");
            out.println("<h2>Entity Manager @SamplePU info: " + getEntityManagerInfo(emSample) + "</h2>");
            out.println("<h2>Entity Manager @TestPU info: " + getEntityManagerInfo(emTest) + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // Test JDBCConnectionProducer
    @Inject
    private Connection conn;
    
    public boolean ping() {
        logger.info("Test ping to Database!");
        try {
            conn.createStatement().executeQuery("SELECT 1 FROM SYSIBM.SYSDUMMY1");
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    // Test EntityManagerProducer
    @Inject @SamplePU
    private EntityManager emSample;
    
    @Inject @TestPU
    private EntityManager emTest;
    
    private String getEntityManagerInfo(EntityManager em) {
        logger.info("Get Entity Manager Info!");
        String info;
        try {
//            Connection connection = em.unwrap(Connection.class);
//            DatabaseMetaData metaData = connection.getMetaData();
            DatabaseMetaData metaData = ((org.hibernate.engine.spi.SessionImplementor)em.getDelegate()).connection().getMetaData();
            info = metaData.getDatabaseProductName() 
                    + " v" + metaData.getDatabaseProductVersion() 
                    + " -> " + metaData.getURL();
        } catch (SQLException ex) {
//            info = ex.getMessage();
            info = (String) em.getEntityManagerFactory().getProperties().get("hibernate.session_factory_name");
        }

//        for (Entry<String, Object> entry : em.getEntityManagerFactory().getProperties().entrySet()) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }
//        info = (String) em.getEntityManagerFactory().getProperties().get("javax.persistence.jdbc.driver");
//        info = (String) em.getEntityManagerFactory().getProperties().get("eclipselink.target-database");
//        info = (String) em.getEntityManagerFactory().getProperties().get("hibernate.connection.driver_class");

//        info = (String) em.getEntityManagerFactory().getProperties().get("hibernate.session_factory_name");

        return info;
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
