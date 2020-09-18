/*
 * File:    CompanyEmployeeUniClient.java
 * Project: EJBClient
 * Date:    23 дек. 2018 г. 18:57:22
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.jpa;

import javax.ejb.EJB;
import ru.lionsoft.javaee.ejb.hello.entity.uni.Company;
import ru.lionsoft.javaee.ejb.hello.entity.uni.Employee;
import ru.lionsoft.javaee.ejb.hello.jpa.CompanyEmployeeOMUni;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class CompanyEmployeeUniClient {
    
    @EJB
    private static CompanyEmployeeOMUni ceom;
    
    public static void main(String[] args) {
        ceom.doSomeStuff();
        for (Company c : ceom.getCompanies()) {
            System.out.println("Here are the employees for company: " + c.getName());
            for (Employee e : c.getEmployees()) {
                System.out.println("\tName: " + e.getName() + ", Sex: " + e.getSex());
            }
            System.out.println();
        }
    }
}
