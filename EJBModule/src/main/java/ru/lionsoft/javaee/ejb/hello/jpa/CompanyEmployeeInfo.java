/*
 * File:    CompanyEmployeeInfo.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:45:25
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

/**
 * Class for Select (JPQL)
 * 
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class CompanyEmployeeInfo {
    
    private String companyName;
    private String employeeName;

    public CompanyEmployeeInfo(String cName, String eName) {
        companyName = cName;
        employeeName = eName;
    }
    
    // setters and getters go here

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    
}
