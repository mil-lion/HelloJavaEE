/*
 * File:    DiscountCode.java
 * Project: HelloEA-ejb
 * Date:    24 дек. 2018 г. 13:06:35
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.helloea.ejb.model.entities;

import java.math.BigDecimal;
import java.util.List;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
@Table(name = "DISCOUNT_CODE")
@XmlRootElement
@JsonbPropertyOrder({"code", "rate"})
@NamedQueries({
    @NamedQuery(name = "DiscountCode.findAll", query = "SELECT d FROM DiscountCode d"),
    @NamedQuery(name = "DiscountCode.findByDiscountCode", query = "SELECT d FROM DiscountCode d WHERE d.code = :discountCode"),
    @NamedQuery(name = "DiscountCode.findByRate", query = "SELECT d FROM DiscountCode d WHERE d.rate = :rate")})
public class DiscountCode extends AuditInfo {

    // ************** Fields ***********************

    @Id
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 1)
    @Column(name = "DISCOUNT_CODE", nullable = false, length = 1)
    private String code;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 4, scale = 2)
    private BigDecimal rate;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discountCode")
    private List<Customer> customers;

    // ************** Constructors ***********************

    public DiscountCode() {
    }

    public DiscountCode(String discountCode) {
        this.code = discountCode;
    }

    // ************** Getters & Setters ***********************

    @XmlAttribute
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @XmlTransient
    @JsonbTransient
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    // ************** Equals & HashCode ***********************

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscountCode)) {
            return false;
        }
        DiscountCode other = (DiscountCode) object;
        if ((this.code == null && other.code != null) 
            || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    // ************** Cast to String ***********************

    @Override
    public String toString() {
        return "DiscountCode{" 
                + "code=" + code 
                + ", rate=" + rate 
                + ", super=" + super.toString() + '}';
    }
    
}
