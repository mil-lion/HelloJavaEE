/*
 * File:    WineClient.java
 * Project: HelloCDI
 * Date:    Jan 5, 2019 8:21:06 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi;

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
 * Тестовый клиент показывающее инъекцию объекта
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@WebServlet(name = "WineClient", urlPatterns = {"/WineClient"})
public class WineClient extends HttpServlet {
    
    // Instantiating the classical way
    private Wine oldWine = new RedWine();

    // Instantiating via field dependency injection
    @Inject
    private Wine newWine;
    
    @Inject
    private Wine newWine2;

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
            out.println("<title>Servlet WineClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WineClient at <a href='" + request.getContextPath() + "'>" 
                    + request.getContextPath() + "<a></h1>");
            out.println("<h2>Creating a new Red Wine the classical way: " + oldWine.getName() + "::" + oldWine.getColor() + " (<i>" + oldWine + "</i>)</h2>");
            out.println("<h4>(Note: For instanting oldWine we had to use new RedWine() resulting in tight coupling.)</h4>");
            out.println("<h2>Creating a new Red Wine using depency injection: " + newWine.getName() + "::" + newWine.getColor() + " (<i>" + newWine + "</i>)</h2>");
            out.println("<h4>(Note: Using DI, we use the interface name and the container instantiates the class for us.)</h4>");
            out.println("<h2>newWine2: " + newWine2.getName() + "::" + newWine2.getColor() + " (<i>" + newWine2 + "</i>)</h2>");
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
