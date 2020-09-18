/*
 * File:    Topic.java
 * Project: Books
 * Date:    Jan 1, 2019 1:20:27 AM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String key;
    private final String title;
    private final String outcome;
    private final String info;
    private final String imageEnabled;
    private final String imageDisabled;
    private boolean isEnabled;

    public Topic(String key, String title, String outcome, String info, String imageEnabled, String imageDisabled, boolean isEnable) {
        this.key = key;
        this.title = title;
        this.outcome = outcome;
        this.info = info;
        this.imageEnabled = imageEnabled;
        this.imageDisabled = imageDisabled;
        this.isEnabled = isEnable;
    }

    public String getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }

    public String getOutcome() {
        return outcome;
    }

    public String getInfo() {
        return info;
    }

    public String getImageEnabled() {
        return imageEnabled;
    }

    public String getImageDisabled() {
        return imageDisabled;
    }
    
    public String getImage() {
        return isEnabled ? imageEnabled : imageDisabled;
    }

    public boolean isIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.key);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Topic other = (Topic) obj;
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Topic{" + "key=" + key + ", title=" + title + ", outcome=" + outcome + ", info=" + info + ", imageEnabled=" + imageEnabled + ", imageDisabled=" + imageDisabled + ", isEnabled=" + isEnabled + '}';
    }

    public static class TopicBuilder {

        private final String key;
        private String title = "";
        private String outcome = "";
        private String info = "";
        private String imageEnabled = "";
        private String imageDisabled = "";
        private boolean isEnabled = true;

        static public TopicBuilder createBuilder(String key) {
            return new TopicBuilder(key);
        }

        private TopicBuilder(String key) {
            this.key = key;
            this.title = key; // defaults to key
        }

        public TopicBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public TopicBuilder setOutcome(String outcome) {
            this.outcome = outcome;
            return this;
        }

        public TopicBuilder setInfo(String info) {
            this.info = info;
            return this;
        }

        public TopicBuilder setImageEnabled(String imageEnabled) {
            this.imageEnabled = imageEnabled;
            return this;
        }

        public TopicBuilder setImageDisabled(String imageDisabled) {
            this.imageDisabled = imageDisabled;
            return this;
        }

        public TopicBuilder setIsEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }
               
        public Topic build() {
            return new Topic(key, title, outcome, info,
                    imageEnabled, imageDisabled, isEnabled);
        }
    }
}
