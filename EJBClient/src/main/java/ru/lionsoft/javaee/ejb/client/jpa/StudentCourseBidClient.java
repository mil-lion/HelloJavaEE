/*
 * File:    StudentCourseBidClient.java
 * Project: EJBClient
 * Date:    23 дек. 2018 г. 22:19:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.client.jpa;

import javax.ejb.EJB;
import ru.lionsoft.javaee.ejb.hello.entity.bid.Course;
import ru.lionsoft.javaee.ejb.hello.entity.bid.Student;
import ru.lionsoft.javaee.ejb.hello.jpa.StudentCourseBid;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class StudentCourseBidClient {

    @EJB
    private static StudentCourseBid sc;
    
    public static void main(String[] args) {

        sc.doSomeStuff();
        for (Student s : sc.getAllStudents()) {
            System.out.println("Student: " + s.getName());
            for (Course c : s.getCourses()) {
                System.out.println("\tCourse: " + c.getCourseName());
            }
        }
        System.out.println();
        for (Course c : sc.getAllCourses()) {
            System.out.println("Course: " + c.getCourseName());
            for (Student s : c.getStudents()) {
                System.out.println("\tStudent: " + s.getName());
            }
        }
    }
    
}
