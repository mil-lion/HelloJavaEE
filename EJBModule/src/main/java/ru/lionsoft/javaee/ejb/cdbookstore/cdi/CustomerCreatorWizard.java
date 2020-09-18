/*
 * File:    CustomerCreatorWizard.java
 * Project: EJBModule
 * Date:    25 дек. 2018 г. 13:02:49
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.cdi;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import ru.lionsoft.javaee.ejb.hello.entity.Account;
import ru.lionsoft.javaee.ejb.hello.entity.Customer;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@ConversationScoped
public class CustomerCreatorWizard {

//    private Login login;
    
    private Account account;
    
    @Inject
    private CustomerService customerService;
    
    @Inject
    private Conversation conversation;

    public void saveLogin() {
        conversation.begin();
//        login = new Login();
        // Задает свойства учетных данных
    }

    public void saveAccount() {
        account = new Account();
        // Задает свойства учетной записи
    }

    public void createCustomer() {
        Customer customer = new Customer();
//        customer.setLogin(login);
//        customer.setAccount(account);
        customerService.createCustomer(customer);
        conversation.end();
    }
}
