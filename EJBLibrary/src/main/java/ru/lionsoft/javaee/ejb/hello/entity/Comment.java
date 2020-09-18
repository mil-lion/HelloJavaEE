/*
 * File:    Comment.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 22:31:17
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
public class Comment implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue
    private Long id;
    
    private String nickname;
    
    private String content;
    
    private Integer note;
    
    @Column(name = "posted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedDate;
    
    // Constructors, getters, setters

    public Comment() {
    }

    public Comment(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", nickname=" + nickname + ", content=" + content + ", note=" + note + ", postedDate=" + postedDate + '}';
    }     
}
