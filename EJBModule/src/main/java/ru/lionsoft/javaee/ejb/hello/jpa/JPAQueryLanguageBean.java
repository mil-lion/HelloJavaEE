/*
 * File:    JPAQueryLanguageBean.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 18:45:25
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
public class JPAQueryLanguageBean {
    
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;
    
    // Bulk Updates and Deletes
    public void deleteAll(String type) {
        Query query = em.createQuery("DELETE FROM " + type);
        query.executeUpdate();
    }
    
    public void updateAll(String type, String field, String value) {
        Query query = em.createQuery("UPDATE " + type + " r SET r." + field + " = " + value);
        query.executeUpdate();
    }
    
    // JPA 2.1: Support for Joins with ON Conditions
    public List obtainActiveEmployeeCount() {
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT j.title, count(e) "
                + "FROM Jobs j LEFT JOIN j.employees e "
                + "ON e.status = 'ACTIVE' "
                + "WHERE j.salary >= 50000 "
                + "GROUP BY j.title", Object[].class);
        List data = new ArrayList();
        if (!query.getResultList().isEmpty()) {
            List<Object[]> tdata = query.getResultList();
            for (Object[] t : tdata) {
                Map resultMap = new HashMap();
                resultMap.put("title", t[0]);
                resultMap.put("count", t[1]);
                data.add(resultMap);
            }
        }
        return data;
    }
    
    // Dynamic Queries and Named Parameters
    public List findByName(String name) {
        return em
                .createQuery("SELECT e FROM Employee e WHERE e.name LIKE :empName")
                .setParameter("empName", name)
                .getResultList();
    }
    
    // Object Construction in SELECT Statements
    public List getSomeInfo() {
        return em.createQuery(
                "SELECT " +
                "NEW ru.lionsoft.javaee.ejb.hello.jpa.CompanyEmployeeInfo(c.name, e.name) " +
                "FROM EmployeeOMBid e JOIN e.company c")
            .getResultList();
    }
}
