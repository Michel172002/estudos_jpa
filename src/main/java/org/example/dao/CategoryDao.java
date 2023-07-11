package org.example.dao;

import org.example.model.Category;

import javax.persistence.EntityManager;

public class CategoryDao {
    private EntityManager em;

    public CategoryDao(EntityManager em) {
        this.em = em;
    }

    public void register(Category category){
        this.em.persist(category);
    }

    public void update(Category category){
        this.em.merge(category);
    }
}
