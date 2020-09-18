/*
 * File:    CompanyEmployeeOMBid.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:56:04
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import java.util.List;
import javax.ejb.Remote;
import ru.lionsoft.javaee.ejb.hello.entity.bid.Company;
import ru.lionsoft.javaee.ejb.hello.entity.bid.Employee;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Remote
public interface CompanyEmployeeOMBid {

    void doSomeStuff();

    List<Company> getCompanies();
    
    List<Employee> getEmployees();
    
}
