/*
 * File:    Employee.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 18:42:43
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity.uni;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity(name = "EmployeeOMUni")
public class Employee implements Serializable {

    public static final long serialVersionUID = 1L; 
    
    private int id;
    private String name;
    private char sex;
    // add later
    private BusinessAddress address;

    public Employee() {
        id = (int) System.currentTimeMillis();
    }

    public Employee(String name, char sex) {
        this.id = (int) System.currentTimeMillis();
        this.name = name;
        this.sex = sex;
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

    @ManyToOne(cascade = CascadeType.ALL)
    public BusinessAddress getAddress() {
        return address;
    }

    public void setAddress(BusinessAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", sex=" + sex + ", address=" + address + '}';
    }
}
