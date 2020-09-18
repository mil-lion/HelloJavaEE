/*
 * File:    Student.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 19:23:52
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity(name = "StudentUni")
public class Student implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private Collection<Course> courses = new ArrayList<>();
    
    public Student() {
        id = (int)System.nanoTime();
    }
    
    public Student(String name) {
        this.id = (int)System.nanoTime();
        this.name = name;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "STUDENTUNI_COURSEUNI")
    public Collection<Course> getCourses() {
        return courses;
    }

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", courses=" + courses.size() + '}';
    }
    
}
