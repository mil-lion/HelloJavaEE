/*
 * File:    StudentCourseBidBean.java
 * Project: EJBModule
 * Date:    23 дек. 2018 г. 19:33:05
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ru.lionsoft.javaee.ejb.hello.entity.bid.Course;
import ru.lionsoft.javaee.ejb.hello.entity.bid.Student;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
public class StudentCourseBidBean implements StudentCourseBid {
    
    @PersistenceContext(unitName = "TestDB")
    private EntityManager em;
    
    @Override
    public void doSomeStuff() {
        Course c1 = new Course("EJB 3.0 101");
        Course c2 = new Course("EJB 3.0 202");

        Student s1 = new Student("Micah");
        s1.getCourses().add(c1);
        c1.getStudents().add(s1);

        Student s2 = new Student("Tes");
        s2.getCourses().add(c1);
        s2.getCourses().add(c2);
        c1.getStudents().add(s2);
        c2.getStudents().add(s2);

        em.persist(s1);
        em.persist(s2);
    }

    @Override
    public List<Student> getAllStudents() {
        Query q = em.createQuery("SELECT s FROM StudentBid s");
        return q.getResultList();
    }
    
    @Override
    public List<Course> getAllCourses() {
        Query q = em.createQuery("SELECT c FROM CourseBid c");
        return q.getResultList();
    }
}
