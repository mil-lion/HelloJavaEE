/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.ejb.hello.ejb21;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * Demonstration stateless session bean.
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class HelloBean implements SessionBean {
    
    private SessionContext ctx;
    
    // ********* EJB-required methods ***********
    
    public void ejbCreate() {
        System.out.println("HelloBean.ejbCreate()");
    }
    
    @Override
    public void ejbRemove() {
        System.out.println("HelloBean.ejbRemove()");
    }
    
    @Override
    public void ejbActivate() {
        System.out.println("ejbActivate()");
    }
    
    @Override
    public void ejbPassivate() {
        System.out.println("HelloBean.ejbPassivate()");
    }
    
    @Override
    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }
    
    // ************ Business methods ***********
    
    public String hello() {
        System.out.println("HelloBean.hello()");
        return "Hello from EJB 2.1!";
    }
}