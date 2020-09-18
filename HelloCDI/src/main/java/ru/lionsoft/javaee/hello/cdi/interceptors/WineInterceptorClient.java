/*
 * File:    WineInterceptorClient.java
 * Project: HelloCDI
 * Date:    Jan 7, 2019 4:38:09 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.interceptors;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "WineInterceptorClient", urlPatterns = {"/WineInterceptorClient"})
@Loggable
public class WineInterceptorClient extends HttpServlet {

    @Inject @Red
    private Wine redWine;

    @Inject @White
    private Wine whiteWine;

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
            out.println("<title>Servlet WineInterceptorClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WineInterceptorClient at <a href='" + request.getContextPath() + "'>" 
                    + request.getContextPath() + "<a></h1>");
            out.println("<h2>redWine: " + redWine.getColor() + " (<i>" + redWine + "</i>)</h2>");
            out.println("<h2>whiteWine: " + whiteWine.getColor() + " (<i>" + whiteWine + "</i>)</h2>");
            test();
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void test() {
        
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
