/*
 * File:    CD.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 23:03:22
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity.table_per_class;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity(name = "CDItem")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "cd_id")),
    @AttributeOverride(name = "title", column = @Column(name = "cd_title")),
    @AttributeOverride(name = "description", column = @Column(name = "cd_description"))
})
public class CD extends Item {

    private static final long serialVersionUID = 1L;
    
    protected String musicCompany;
    
    protected Integer numberOfCDs;
    
    protected Double totalDuration;
    
    protected String gender;
    
    // Constructors

    public CD() {
        super();
    }

    public CD(Long id) {
        super(id);
    }

    // Getters, setters

    public String getMusicCompany() {
        return musicCompany;
    }

    public void setMusicCompany(String musicCompany) {
        this.musicCompany = musicCompany;
    }

    public Integer getNumberOfCDs() {
        return numberOfCDs;
    }

    public void setNumberOfCDs(Integer numberOfCDs) {
        this.numberOfCDs = numberOfCDs;
    }

    public Double getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Double totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "CD{" 
                + "id=" + id 
                + ", title=" + title 
                + ", price=" + price 
                + ", description=" + description 
                + ", musicCompany=" + musicCompany 
                + ", gender=" + gender 
                + ", numberOfCDs=" + numberOfCDs 
                + ", totalDuration=" + totalDuration 
                + '}';
    }
    
}
