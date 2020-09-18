/*
 * File:    CustomerEJB.java
 * Project: EJBModule
 * Date:    24 дек. 2018 г. 11:28:29
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.stateless;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.interceptor.AroundInvoke;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ru.lionsoft.javaee.ejb.hello.entity.Customer;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Stateless
//@Interceptors(LoggingInterceptor.class)
@Interceptors(ProfileInterceptor.class)
public class CustomerEJB {

    private static final Logger LOG = Logger.getLogger(CustomerEJB.class.getName());
    
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;
    
    @Resource 
    private TimerService timerService;

    @PostConstruct
    public void init() {
        // ...
        System.out.println("CustomerEJB::init");
    }
    
//    @Interceptors(LoggingInterceptor.class)
    public void createCustomer(Customer customer) {
        em.persist(customer);
        
        // Timer Schedule
        ScheduleExpression birthDay = new ScheduleExpression()
                .dayOfMonth(customer.getBirthDay())
                .month(customer.getBirthMonth());
        timerService.createCalendarTimer(birthDay, new TimerConfig(customer, true));
    }
    
    @Timeout
    public void sendBirthdayEmail(Timer timer) {
        Customer customer = (Customer) timer.getInfo();
        // ...
        System.out.println("Send Birthday Email to " + customer.getEmail());
    }    

    public Customer findCustomerById(Long id) {
        return em.find(Customer.class, id);
    }

    public void removeCustomer(Long id) {
        em.remove(em.find(Customer.class, id));
    }

    @ExcludeClassInterceptors
    public void updateCustomer(Customer customer) {
        em.merge(customer);
    }

    // Around-Invoke Interceptors
    
//    @AroundInvoke
//    private Object logMethod(InvocationContext ic) throws Exception {
//        System.out.println("Entering method: " + ic.getTarget().toString() + "::" + ic.getMethod().getName());
//        LOG.entering(ic.getTarget().toString(), ic.getMethod().getName());
//        try {
//            return ic.proceed();
//        } finally {
//            System.out.println("Exiting method: " + ic.getTarget().toString() + "::" + ic.getMethod().getName());
//            LOG.exiting(ic.getTarget().toString(), ic.getMethod().getName());
//        }
//    }
}
