/*
 * File:    Customer.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 22:51:29
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity(name = "CustomerSmpl")
@Access(AccessType.FIELD)
public class Customer implements Serializable {
    
    public static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    private String email;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;
    
    @Embedded
    private Address address;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Transient
    private Integer age;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    // Constructors, getters, setters

    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getBirthDay() {
        return new SimpleDateFormat("dd").format(dateOfBirth);
    }

    public String getBirthMonth() {
        return new SimpleDateFormat("MM").format(dateOfBirth);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + ", creationDate=" + creationDate + '}';
    }
}
