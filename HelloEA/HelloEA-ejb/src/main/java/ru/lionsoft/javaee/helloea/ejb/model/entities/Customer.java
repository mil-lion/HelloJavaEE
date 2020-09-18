/*
 * File:    Customer.java
 * Project: HelloEA-ejb
 * Date:    24 дек. 2018 г. 13:06:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.helloea.ejb.model.entities;

import java.util.Date;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ru.lionsoft.javaee.helloea.xml.adapters.DateXmlAdapter;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@XmlType(propOrder = {"id", "discountCode", "zip", "address", "contact", "creditLimit", "lastLoad"})
@JsonbPropertyOrder({"id", "discountCode", "zip", "address", "contact", "creditLimit", "lastLoad"})
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.id = :customerId"),
    @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name"),
    @NamedQuery(name = "Customer.findByAddressline1", query = "SELECT c FROM Customer c WHERE c.address.addressline1 = :addressline1"),
    @NamedQuery(name = "Customer.findByAddressline2", query = "SELECT c FROM Customer c WHERE c.address.addressline2 = :addressline2"),
    @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM Customer c WHERE c.address.city = :city"),
    @NamedQuery(name = "Customer.findByState", query = "SELECT c FROM Customer c WHERE c.address.state = :state"),
    @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.contact.phone = :phone"),
    @NamedQuery(name = "Customer.findByFax", query = "SELECT c FROM Customer c WHERE c.contact.fax = :fax"),
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.contact.email = :email"),
    @NamedQuery(name = "Customer.findByCreditLimit", query = "SELECT c FROM Customer c WHERE c.creditLimit = :creditLimit")})
public class Customer extends AuditInfo {

    // ************** Fields ***********************
 
    @Id
    @Basic(optional = false)
//    @NotNull
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Integer id;
    
//    @Size(max = 30)
    @Column(length = 30)
    private String name;
    
    @Embedded
    private Address address;
    
    @Embedded
    private ContactInfo contact;
    
    @Column(name = "CREDIT_LIMIT")
    private Integer creditLimit;
    
    @JoinColumn(name = "DISCOUNT_CODE", referencedColumnName = "DISCOUNT_CODE", nullable = false)
    @ManyToOne(optional = false)
    private DiscountCode discountCode;
    
    @JoinColumn(name = "ZIP", referencedColumnName = "ZIP_CODE", nullable = false)
    @ManyToOne(optional = false)
    private MicroMarket zip;
    
    @Transient
    private Date lastLoad;

    // ************** Constructors ***********************

    public Customer() {
    }

    public Customer(Integer customerId) {
        this.id = customerId;
    }

    // ************** Getters & Setters ***********************

    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactInfo getContact() {
        return contact;
    }

    public void setContact(ContactInfo contact) {
        this.contact = contact;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }

    public MicroMarket getZip() {
        return zip;
    }

    public void setZip(MicroMarket zip) {
        this.zip = zip;
    }

    @XmlSchemaType(name = "datetime")
    @XmlJavaTypeAdapter(DateXmlAdapter.class)
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss")
    public Date getLastLoad() {
        return lastLoad;
    }

    public void setLastLoad(Date lastLoad) {
        this.lastLoad = lastLoad;
    }

    // ************** Equals & HashCode ***********************

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) 
            || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    // ************** Cast to String ***********************

    @Override
    public String toString() {
        return "Customer{" 
                + "id=" + id + ", name=" + name 
                + ", address=" + address + ", contact=" + contact 
                + ", creditLimit=" + creditLimit 
                + ", discountCode=" + (discountCode == null ? "null" : discountCode.getCode())
                + ", zip=" + (zip == null ? "null" : zip.getCode()) 
                + ", super=" + super.toString()
                + '}';
    }
        
    // ************** Callbacks ***********************
    
    @PostLoad
    public void postLoad() {
        lastLoad = new Date();
    }
}
