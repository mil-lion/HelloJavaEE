/*
 * File:    Topics.java
 * Project: Books
 * Date:    Jan 1, 2019 1:58:17 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2019 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
public class Topics implements Serializable {

    private Optional<Topic> activeTopic = Optional.empty();
    private final Set<Topic> topics = new LinkedHashSet<>();

    public Set<Topic> getTopics() {
        return topics;
    }

    public void clear() {
        topics.clear();
    }

    public void addTopic(String title) {
        addTopic(Topic.TopicBuilder.createBuilder(title).build());
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void remove(String key) {
        Optional<Topic> topic = findTopic(key);
        topic.ifPresent(t -> topics.remove(t));
    }

    public void remove(Topic topic) {
        topics.remove(topic);
    }

    public Optional<Topic> findTopic(String key) {
        return topics.stream()
                .filter(topic -> topic.getKey().equals(key))
                .findAny();
    }

    /* pre-Java 8 code example
    public Topic findTopic(String key) {
        for (Topic topic : topics) {
            if (topic.getKey().equals(key)) {
                return topic;
            }
        }
        return Topic.TopicBuilder.createBuilder("").build();
    }
    */
    
    public Optional<Topic> getActiveTopic() {
        return activeTopic;
    }
    
    public void setActive(String key) {
        activeTopic = findTopic(key);
    }
}
