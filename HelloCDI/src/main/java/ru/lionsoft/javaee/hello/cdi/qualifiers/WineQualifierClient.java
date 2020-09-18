/*
 * File:    WineQualifierClient.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 8:41:51 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.qualifiers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.enterprise.inject.New;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@WebServlet(name = "WineQualifierClient", urlPatterns = {"/WineQualifierClient"})
public class WineQualifierClient extends HttpServlet {

    // Instantiating via field dependency injection
    @Inject
    private Wine defaultWine;
    
    @Inject @Red
    private Wine redWine;

    @Inject @White //@New
    private Wine whiteWine;

    @Inject @Red
    private Wine newWine;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WineQualifierClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WineQualifierClient at <a href='" + request.getContextPath() + "'>" 
                    + request.getContextPath() + "<a></h1>");
            out.println("<h2>defaultWine: " + defaultWine.getName() + "::" + defaultWine.getColor() + " (<i>" + defaultWine + "</i>)</h2>");
            out.println("<h2>redWine: " + redWine.getName() + "::" + redWine.getColor() + " (<i>" + redWine + "</i>)</h2>");
            out.println("<h2>whiteWine: " + whiteWine.getName() + "::" + whiteWine.getColor() + " (<i>" + whiteWine + "</i>)</h2>");
            out.println("<h2>newWine: " + newWine.getName() + "::" + newWine.getColor() + " (<i>" + newWine + "</i>)</h2>");
            out.println("</body>");
            out.println("</html>");
        }
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
