/*
 * File:    TinyCalculator.java
 * Project: TinyCalculator
 * Date:    27 дек. 2018 г. 18:42:42
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.tinycalculator;

import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Named
@RequestScoped
public class TinyCalculator {

    private static final Logger LOG = Logger.getLogger(TinyCalculator.class.getName());

    // Fields
    private double param1;

    private double param2;

    private double result;

    /**
     * Creates a new instance of TinyCalculator
     */
    public TinyCalculator() {
        LOG.info("constructor TinyCalculator");
    }

    // Getters & Setters
    public double getParam1() {
        return param1;
    }

    public void setParam1(double param1) {
        this.param1 = param1;
    }

    public double getParam2() {
        return param2;
    }

    public void setParam2(double param2) {
        this.param2 = param2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    // Business Methods
    public String add() {
        result = param1 + param2;
        return "";
    }

    public String subtract() {
        result = param1 - param2;
        return "";
    }

    public String multiply() {
        result = param1 * param2;
        return "";
    }

    public String divide() {
        result = param1 / param2;
        return "";
    }

    /**
     * printTree might be used within an action of a button 
     * As required for an action, it returns a String
     * @return ""
     */
    public String printTree() {
        UIViewRoot root = FacesContext.getCurrentInstance().getViewRoot();
        printTree(root, 0);
        return "";
    }

    private void printTree(UIComponent element, int level) {
        logElement(level, element);
        for (UIComponent child : element.getChildren()) {
            printTree(child, level + 1);
        }
    }

    private void logElement(int level, UIComponent element) {
        String out = "";
        for (int i = 0; i < level; i++) {
            out += "----";
        }
        out += element.getClass().getSimpleName()
                + " - " + element.getFamily()
                + " - " + element.getRendererType();
        LOG.info(out);
    }
}
