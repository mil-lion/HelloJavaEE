/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lionsoft.javaee.ejb.model.entities;

import java.util.List;
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

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
@Table(name = "MICRO_MARKET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MicroMarket.findAll", query = "SELECT m FROM MicroMarket m"),
    @NamedQuery(name = "MicroMarket.findByZipCode", query = "SELECT m FROM MicroMarket m WHERE m.code = :zipCode"),
    @NamedQuery(name = "MicroMarket.findByRadius", query = "SELECT m FROM MicroMarket m WHERE m.radius = :radius"),
    @NamedQuery(name = "MicroMarket.findByAreaLength", query = "SELECT m FROM MicroMarket m WHERE m.areaLength = :areaLength"),
    @NamedQuery(name = "MicroMarket.findByAreaWidth", query = "SELECT m FROM MicroMarket m WHERE m.areaWidth = :areaWidth")})
public class MicroMarket extends AuditInfo {

    private static final long serialVersionUID = 1L;
    
    // ************** Fields ***********************

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ZIP_CODE", nullable = false, length = 10)
    private String code;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 52)
    private Double radius;

    @Column(name = "AREA_LENGTH", precision = 52)
    private Double areaLength;

    @Column(name = "AREA_WIDTH", precision = 52)
    private Double areaWidth;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zip")
    private List<Customer> customers;

    // ************** Constructors ***********************

    public MicroMarket() {
    }

    public MicroMarket(String zipCode) {
        this.code = zipCode;
    }

    // ************** Getters & Setters ***********************

    @XmlAttribute
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getAreaLength() {
        return areaLength;
    }

    public void setAreaLength(Double areaLength) {
        this.areaLength = areaLength;
    }

    public Double getAreaWidth() {
        return areaWidth;
    }

    public void setAreaWidth(Double areaWidth) {
        this.areaWidth = areaWidth;
    }

    @XmlTransient
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
        if (!(object instanceof MicroMarket)) {
            return false;
        }
        MicroMarket other = (MicroMarket) object;
        if ((this.code == null && other.code != null) 
            || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    // ************** Cast to String ***********************

    @Override
    public String toString() {
        return "MicroMarket{" 
                + "code=" + code 
                + ", radius=" + radius 
                + ", areaLength=" + areaLength 
                + ", areaWidth=" + areaWidth 
                + ' ' + super.toString()
                + '}';
    }
}
