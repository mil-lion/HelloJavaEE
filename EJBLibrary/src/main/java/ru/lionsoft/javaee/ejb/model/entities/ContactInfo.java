/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.ejb.model.entities;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Embeddable
@XmlType(propOrder = {"phone", "fax", "email"})
@JsonbPropertyOrder({"phone", "fax", "email"})
public class ContactInfo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    // ************** Fields ***********************
 
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 12)
    @Column(length = 12)
    private String phone;
    
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 12)
    @Column(length = 12)
    private String fax;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(length = 40)
    private String email;

    // ************** Constructors ***********************

    public ContactInfo() {
    }
    
    // ************** Getters & Setters ***********************

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // ************** Cast to String ***********************

}
