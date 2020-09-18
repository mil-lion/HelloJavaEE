/*
 * File:    AuditInfoListener.java
 * Project: HelloEA-ejb
 * Date:    Feb 24, 2019 7:33:55 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.helloea.ejb.model.entities;

import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class AuditInfoListener {
 
    // ************** Callbacks (Triggers) ********************

    @Resource
    private SessionContext ctx;
    
    @PrePersist
    public void beforeInsert(AuditInfo entity) {
        String currentUser = ctx.getCallerPrincipal().getName();
        entity.setUserCreated(currentUser);
        entity.setDateCreated(new Date());
        entity.setUserUpdated(currentUser);
        entity.setDateUpdated(new Date());
    }
    
    @PreUpdate
    public void beforeUpdate(AuditInfo entity) {
        String currentUser = ctx.getCallerPrincipal().getName();
        entity.setUserUpdated(currentUser);
        entity.setDateUpdated(new Date());
    }

}
