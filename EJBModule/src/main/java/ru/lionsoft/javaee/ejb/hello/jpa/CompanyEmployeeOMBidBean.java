/*
 * File:    CompanyEmployeeOMBidBean.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:45:25
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ru.lionsoft.javaee.ejb.hello.entity.bid.Company;
import ru.lionsoft.javaee.ejb.hello.entity.bid.Employee;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
public class CompanyEmployeeOMBidBean implements CompanyEmployeeOMBid {
    
    @PersistenceContext(unitName = "TestPU")
    EntityManager em;
    
    @Override
    public void doSomeStuff() {
        Company company = new Company("M*Power Internet Services, Inc.");
        Collection<Employee> employees = company.getEmployees();
        employees.add(new Employee("Micah Silverman", 'M', company));
        employees.add(new Employee("Tes Silverman", 'F', company));
        em.persist(company);
        
        company = new Company("Sun Microsystems");
        employees = company.getEmployees();
        employees.add(new Employee("Rima Patel", 'F', company));
        employees.add(new Employee("James Gosling", 'M', company));
        em.persist(company);
    }
    
    @Override
    public List<Company> getCompanies() {
        Query q = em.createQuery("SELECT c FROM CompanyOMBid c");
        return q.getResultList();
    }

    @Override
    public List<Employee> getEmployees() {
        Query q = em.createQuery("SELECT e FROM EmployeeOMBid e");
        return q.getResultList();
    }
}
