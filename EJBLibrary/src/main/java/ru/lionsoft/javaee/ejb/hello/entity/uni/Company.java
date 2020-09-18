/*
 * File:    Company.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 18:40:04
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity.uni;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity(name = "CompanyOMUni")
public class Company implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private Collection<Employee> employees;

    public Company() {
        id = (int)System.currentTimeMillis();
    }

    public Company(String name) {
        this.id = (int)System.currentTimeMillis();
        this.name = name;
        this.employees = new ArrayList<>();
    }
    
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", name=" + name + ", employees=" + employees + '}';
    }
    
}
