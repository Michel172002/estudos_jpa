package org.example.dao;

import org.example.model.Category;

import javax.persistence.EntityManager;
import java.util.List;

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

    public void delete(Category category){
        category = em.merge(category);
        this.em.remove(category);
    }

    public Category findById(Long id){
        return em.find(Category.class, id);
    }

    public List<Category> findAll(){
        String jpql = "SELECT c FROM Category c";
        return em.createQuery(jpql).getResultList();
    }

    public List<Category> findByName(String name){
        String jpql = "SELECT c FROM Category c WHERE c.name = ?1";
        return em.createQuery(jpql)
                .setParameter(1, name)
                .getResultList();
    }
}
