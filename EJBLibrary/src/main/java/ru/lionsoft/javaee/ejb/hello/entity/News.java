/*
 * File:    News.java
 * Project: EJBLibrary
 * Date:    23 дек. 2018 г. 22:34:19
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.ejb.hello.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Entity
public class News implements Serializable {

    @Id 
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String content;
    
    @OneToMany(fetch = FetchType.EAGER)
    @OrderBy("postedDate DESC")
//    @OrderColumn(name = "posted_index")
    private List<Comment> comments;

    // Constructors, getters, setters

    public News() {
    }

    public News(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "News{" + "id=" + id + ", content=" + content + ", comments=" + comments + '}';
    }
    
}
