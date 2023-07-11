package org.example;

import org.example.dao.CategoryDao;
import org.example.dao.ProductDao;
import org.example.model.Category;
import org.example.model.Product;
import org.example.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        registerCategory();

        EntityManager em = JpaUtil.getEntityManager();

        CategoryDao categoryDao = new CategoryDao(em);
        ProductDao productDao = new ProductDao(em);

//        Category c = categoryDao.findById(1l);
//        System.out.println(c.getName());

//        List<Category> categories = categoryDao.findAll();
//
//        List<Category> categories = categoryDao.findByName("RANDOM");
//        categories.forEach(category -> System.out.println(category.getName()));

//        List<Product> products = productDao.findByCategoryName("CELLPHONES");
//        products.forEach(product -> System.out.println(product.getName()));

        BigDecimal price = productDao.findPriceProductById(1l);
        System.out.println(price);
    }

    public static void registerCategory(){
        EntityManager em = JpaUtil.getEntityManager();

        Category categoryCell = new Category("CELLPHONES");
        Category categoryRandom = new Category("RANDOM");

        Product product = new Product("Celular", "descrição", new BigDecimal("2000"), categoryCell);

        CategoryDao categoryDao = new CategoryDao(em);
        ProductDao productDao = new ProductDao(em);

        //insere no bd o objeto cellphone
        em.getTransaction().begin();
        categoryDao.register(categoryCell);
        categoryDao.register(categoryRandom);
        productDao.register(product);

        //atualizar
//        categoryCell.setName("Test");
//        categoryDao.update(categoryCell);
//        em.flush();

        //Remover
//        em.clear();
//        categoryDao.delete(categoryCell);
//        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}