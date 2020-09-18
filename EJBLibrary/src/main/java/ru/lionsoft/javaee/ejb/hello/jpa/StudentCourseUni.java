/*
 * File:    StudentCourseUni.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 19:44:11
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import java.util.List;
import javax.ejb.Remote;
import ru.lionsoft.javaee.ejb.hello.entity.uni.Student;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Remote
public interface StudentCourseUni {

    void doSomeStuff();

    List<Student> getAllStudents();
    
}
