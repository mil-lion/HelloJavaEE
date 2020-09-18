/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.ejb.hello.ejb32;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Stateless session bean
 * 
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
@Remote(Hello.class)
public class HelloBean implements Hello {

    @Override
    public String hello() {
        System.out.println("HelloBean.hello()");
        return "Hello from EJB3.2!";
    }
    
}
