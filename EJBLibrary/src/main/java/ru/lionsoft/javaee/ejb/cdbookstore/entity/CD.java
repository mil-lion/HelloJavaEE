/*
 * File:    CD.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 23:03:22
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.cdbookstore.entity;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "cd_id")),
    @AttributeOverride(name = "title", column = @Column(name = "cd_title", nullable = false, updatable = false)),
    @AttributeOverride(name = "description", column = @Column(name = "cd_description", length = 2000))
})
@NamedQueries(@NamedQuery(name = "findAllCDs", query = "SELECT c FROM CD c"))
public class CD extends Item {

    private static final long serialVersionUID = 1L;
    
    protected String musicCompany;

    protected Integer numberOfCDs;

    protected Double totalDuration;

    protected String gender;

    @Lob
    protected byte[] cover;

    @ElementCollection
    @CollectionTable(name="track")
    @MapKeyColumn (name = "position")
    @Column(name = "title")
    protected Map<Integer, String> tracks = new HashMap<>();

    // Constructors, getters, setters    

    public CD() {
    }

    public CD(Long id) {
        this.id = id;
    }

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

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public Map<Integer, String> getTracks() {
        return tracks;
    }

    public void setTracks(Map<Integer, String> tracks) {
        this.tracks = tracks;
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
                + ", tracks=" + tracks 
                + '}';
    }
}
