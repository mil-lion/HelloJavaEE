/*
 * File:    CategoryEditor.java
 * Project: Books
 * Date:    Dec 30, 2018 11:38:01 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ru.lionsoft.javaee.jsf.books.common.Utilities;
import ru.lionsoft.javaee.jsf.books.common.Utilities.HandleDefault;
import ru.lionsoft.javaee.jsf.books.model.Category;
import ru.lionsoft.javaee.jsf.books.model.Topic;
import ru.lionsoft.javaee.jsf.books.model.Topics;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
@Named
@SessionScoped
public class CategoryEditor implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(CategoryEditor.class.getName());

    private static final String CATEGORY = "category";
    private Topics topics;

    @Inject
    private CategoryService categoryService;

    private List<Category> categories;
    private List<Category> deletedCategories;

    @PostConstruct
    private void init() {
//        categories = new ArrayList<>();
//        categories.add(new Category(){{setId(1); setName("Java");}});
//        categories.add(new Category(){{setId(2); setName("Web");}});
        categories = categoryService.findAll();
        deletedCategories = new ArrayList<>();
        initTopics();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String addCategory() {
        categories.add(new Category());
        return "";
    }

    public String deleteCategory(Category category) {
        if (category.getId() >= 0) {
            deletedCategories.add(category);
        }
        categories.remove(category);
        return "";
    }

    public String save() {
//        String saveCetegories = categories
//            .stream()
//            .filter(cat -> !cat.getName().isEmpty())
//            .map(cat -> cat.toString())
//            .collect(Collectors.joining(", "));
//        LOG.log(Level.INFO, "Save categories: {0}", saveCetegories);

        for (Category category : categories) {
            categoryService.save(category);
        }
        for (Category category : deletedCategories) {
            categoryService.delete(category);
        }
        deletedCategories = new ArrayList<>();

        return "";
    }

    public static String getMessage(String key) {
        ResourceBundle messageBundle = ResourceBundle.getBundle("ru.lionsoft.javaee.jsf.books.messages");
        try {
            return messageBundle.getString(key);
        } catch (MissingResourceException e) {
            return "<unknown resource: " + key + ">";
        }
    }

    private void initTopics() {
        topics = new Topics();
        Topic topic = Topic.TopicBuilder
                .createBuilder(CATEGORY)
                .setTitle(Utilities.getMessage("lblCategory"))
                .setOutcome("categoryEditor.xhtml")
                .build();
        topics.addTopic(topic);
        for (String lang : Utilities.getSupportedLocales(HandleDefault.Exclude)) {
            topic = Topic.TopicBuilder
                    .createBuilder(lang)
                    .setOutcome("categoryTranslator.xhtml")
                    .build();
            topics.addTopic(topic);
        }
        topics.setActive(CATEGORY);
    }

    public String changeTab(String newTopicKey) {
        if (topics.getActiveTopic().get().getKey().equals(newTopicKey)) {
            return "";
        }
        topics.setActive(newTopicKey);
        if (!newTopicKey.equals(CATEGORY)) {
            initTranslation(newTopicKey);
        }
        return topics.getActiveTopic().get().getOutcome();
    }
    
    private void initTranslation(String langCode) {
        // ensure there is an element in the map for this language
        categories.stream().forEach(c -> {
            if (c.getTranslatedName(langCode).isEmpty()) {
                c.setTranslatedName(langCode, "");
            }
        });
    }

    public Set<Topic> getTopics() {
        return topics.getTopics();
    }

    public boolean isActive(Topic topic) {
        Optional<Topic> activeTopic = topics.getActiveTopic();
        if (activeTopic.isPresent()) {
            return activeTopic.get().equals(topic);
        }
        return false;
    }
}
