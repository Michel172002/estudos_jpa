package org.example.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    //colocar o name do persistence-unit em persistence.xml
    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("projectHibernate");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
