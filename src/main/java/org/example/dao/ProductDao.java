package org.example.dao;

import org.example.model.Product;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductDao {
    private EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }

    public void register(Product product){
        this.em.persist(product);
    }

    public void update(Product product){
        this.em.merge(product);
    }

    public void delete(Product product){
        product = em.merge(product);
        this.em.remove(product);
    }

    public Product findById(Long id){
        return em.find(Product.class, id);
    }

    public List<Product> findAll(){
        String jpql = "SELECT p FROM Product";
        return em.createQuery(jpql).getResultList();
    }

    public List<Product> findByName(String name){
        String jpql = "SELECT p FROM Product p WHERE p.name = ?1";
        return em.createQuery(jpql)
                .setParameter(1, name)
                .getResultList();
    }

    public List<Product> findByCategoryName(String name){
        String jpql = "SELECT p FROM Product p WHERE p.category.name = ?1";
        return em.createQuery(jpql)
                .setParameter(1, name)
                .getResultList();
    }

    public BigDecimal findPriceProductById(Long id){
        String jpql = "SELECT p.price FROM Product p WHERE p.id = ?1";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter(1, id)
                .getSingleResult();
    }
}
