package br.com.alura.loja.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtilFactory {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
