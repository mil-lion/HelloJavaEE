/*
 * File:    CategoryService.java
 * Project: Books
 * Date:    Dec 30, 2018 11:38:01 PM
 * Author:  Igor Morenko <morenko at lionsoft.ru>
 * 
 * Copyright 2005-2018 LionSoft LLC. All rights reserved.
 */
package ru.lionsoft.javaee.jsf.books.control;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import ru.lionsoft.javaee.jsf.books.model.Category;

/**
 *
 * @author Igor Morenko <morenko at lionsoft.ru>
 */
//@Stateless
@RequestScoped
@Transactional
public class CategoryService {

    @PersistenceContext(unitName = "BooksPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public Category create(Category entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public Category read(Object id) {
        return getEntityManager().find(Category.class, id);
    }

    public Category update(Category entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(Category entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Convenience method, to create or update automatically
     *
     * @param entity
     * @return managed entity
     */
    public Category save(Category entity) {
        if (entity.getId() < 0) {
            return create(entity);
        }
        return update(entity);
//        return getEntityManager().merge(entity);
    }

    public List<Category> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Category.class));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public String checkState(Category entity){
        return entity + (em.contains(entity) ? "attached" : "detached");
    }
}
