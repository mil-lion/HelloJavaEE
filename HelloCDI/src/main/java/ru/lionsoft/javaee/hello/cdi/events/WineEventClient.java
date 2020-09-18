/*
 * File:    WineEventClient.java
 * Project: HelloCDI
 * Date:    Jan 8, 2019 10:40:37 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.hello.cdi.events;

import java.io.IOException;
import java.io.PrintWriter;
import javax.enterprise.event.Event;
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
@WebServlet(name = "WineEventClient", urlPatterns = {"/WineEventClient"})
public class WineEventClient extends HttpServlet {

    // Instantiating via field dependency injection
    private final Wine[] wines = {new RedWine(), new RoseWine(), 
        new SparklingWine(), new WhiteWine()};
    
    @Inject @Added
    private Event<Wine> wineAddedEvent;
    
    @Inject @Removed
    private Event<Wine> wineRemovedEvent;
    
    @Inject
    private ShoppingCart shoppingCart;
    
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WineEventClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WineEventClient at <a href='" + request.getContextPath() + "'>" 
                    + request.getContextPath() + "<a></h1>");
            
            // Print Form
            out.println("<form method='GET'>");
            out.println("<p>Wine Color: <select name='wine'>");
            out.println("<option value='-1'>- Selected Color -</option>");
            for (int i = 0; i < wines.length; i++) {
                out.println("<option value='" + i + "'>" + wines[i].getColor() + "</option>");
            }
            out.println("</select></p>");
            out.println("<p><input type='submit' name='btnAdd' value='Add' />");
            out.println("<input type='submit' name='btnDel' value='Remove' />");
            out.println("<input type='submit' name='btnClear' value='Clear' /></p>");
            out.println("</form>");
            
            // Get parameter 'wine'
            int i = -1;
            String wineParam = request.getParameter("wine");
            if (wineParam != null) {
                i = Integer.parseInt(wineParam);
                if (i >= wines.length) i = wines.length - 1;
            }
            
            // Send Event
            if (i >= 0) {
                Wine wine = wines[i];
                if (request.getParameter("btnAdd") != null) {
                    // Add Button Press
                    wineAddedEvent.fire(wine);
                    out.println("<h2>Fire Added Wine: " + wine.getColor() + " (<i>" + wine + "</i>)</h2>");
                }
                if (request.getParameter("btnDel") != null) {
                    // Remove Button Press
                    wineRemovedEvent.fire(wine);
                    out.println("<h2>Fire Removed Wine: " + wine.getColor() + " (<i>" + wine + "</i>)</h2>");
                }
            }
            if (request.getParameter("btnClear") != null) {
                // Clear Button Press
                // without event
                shoppingCart.clear();
            }
            
            // Print Shopping Cart
            out.println("<h2>Shopping Cart List:</h2>");
            for (Wine item : shoppingCart.getWines()) {
                out.println("<h4>" + item.getColor() + "</h4>");
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
