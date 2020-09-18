/*
 * File:    Employee.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 18:42:43
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity.bid;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity(name = "EmployeeOMBid")
public class Employee implements Serializable {

    public static final long serialVersionUID = 1L; 
    
    private int id;
    private String name;
    private char sex;
    private Company company;

    public Employee() {
        id = (int) System.currentTimeMillis();
    }

    public Employee(String name, char sex, Company company) {
        this.id = (int) System.currentTimeMillis();
        this.name = name;
        this.sex = sex;
        this.company = company;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @ManyToOne
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", sex=" + sex + ", company=" + (company == null ? "null" : company.getId()) + '}';
    }
}
