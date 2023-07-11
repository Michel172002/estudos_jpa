package org.example.dao;

import org.example.model.Product;

import javax.persistence.EntityManager;
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
}
