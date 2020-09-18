/*
 * File:    AuditInfo.java
 * Project: HelloEA-ejb
 * Date:    24 дек. 2018 г. 13:06:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.helloea.ejb.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ru.lionsoft.javaee.helloea.xml.adapters.DateXmlAdapter;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@MappedSuperclass
@EntityListeners(AuditInfoListener.class)
@XmlRootElement
@XmlType(propOrder = {"userCreated", "dateCreated", "userUpdated", "dateUpdated"})
@JsonbPropertyOrder({"userCreated", "dateCreated", "userUpdated", "dateUpdated"})
public class AuditInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    // ************** Fields ***********************
    
    @Column(name = "USER_CREATED")
    private String userCreated;
    
    @Column(name = "DATE_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    @Column(name = "USER_UPDATED")
    private String userUpdated;
    
    @Column(name = "DATE_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;

    // ************** Getters & Setters ***********************

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    @XmlSchemaType(name = "datetime")
    @XmlJavaTypeAdapter(DateXmlAdapter.class)
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss")
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(String userUpdated) {
        this.userUpdated = userUpdated;
    }

    @XmlSchemaType(name = "datetime")
    @XmlJavaTypeAdapter(DateXmlAdapter.class)
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss")
    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
    
    // ************** Cast to String ***********************

    @Override
    public String toString() {
        return "AuditInfo{" 
                + "userCreated=" + userCreated 
                + ", dateCreated=" + dateCreated 
                + ", userUpdated=" + userUpdated 
                + ", dateUpdated=" + dateUpdated 
                + '}';
    }

}
