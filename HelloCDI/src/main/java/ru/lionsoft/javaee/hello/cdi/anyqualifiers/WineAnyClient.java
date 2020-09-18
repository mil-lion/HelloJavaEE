/*
 * File:    WineAnyClient.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 9:00:03 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.anyqualifiers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Тестовый клиент показывающий работу квалификтора @Any
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@WebServlet(name = "WineAnyClient", urlPatterns = {"/WineAnyClient"})
public class WineAnyClient extends HttpServlet {
    
    // Instantiating via field dependency injection
    @Inject @Any
    private Instance<Wine> allWines;

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
            out.println("<title>Servlet WineAnyClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WineAnyClient at <a href='" + request.getContextPath() + "'>" 
                    + request.getContextPath() + "<a></h1>");
            out.println("<h2>@Any qualifier will help us iterate thru all the implementation of Wine interface: </h2>");
            for (Wine wine : allWines) {
                out.println("<h3>" + wine.getName() + "::" + wine.getColor() + " (<i>" + wine + "</i>)</h3>");
            }
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
