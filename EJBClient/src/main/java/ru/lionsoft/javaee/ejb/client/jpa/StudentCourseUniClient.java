/*
 * File:    StudentCourseUniClient.java
 * Project: EJBClient
 * Date:    23 дек. 2018 г. 22:19:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.jpa;

import javax.ejb.EJB;
import ru.lionsoft.javaee.ejb.hello.entity.uni.Course;
import ru.lionsoft.javaee.ejb.hello.entity.uni.Student;
import ru.lionsoft.javaee.ejb.hello.jpa.StudentCourseUni;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class StudentCourseUniClient {

    @EJB
    private static StudentCourseUni sc;
    
    public static void main(String[] args) {

        sc.doSomeStuff();
        for (Student s : sc.getAllStudents()) {
            System.out.println("Student: " + s.getName());
            for (Course c : s.getCourses()) {
                System.out.println("\tCourse: " + c.getCourseName());
            }
        }
    }
    
}
