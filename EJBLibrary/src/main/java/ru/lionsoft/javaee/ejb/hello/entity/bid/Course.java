/*
 * File:    Course.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 19:26:51
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity.bid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity(name = "CourseBid")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String courseName;
    private Collection<Student> students = new ArrayList<>();

    public Course() {
        id = (int)System.nanoTime();
    }

    public Course(String courseName) {
        this.id = (int)System.nanoTime();
        this.courseName = courseName;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", courseName=" + courseName + ", students=" + students.size() + '}';
    }

    
}
