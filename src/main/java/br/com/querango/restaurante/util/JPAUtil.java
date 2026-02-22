package br.com.querango.restaurante.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory QUERANGO = Persistence.createEntityManagerFactory("queRango");

    public static EntityManager getEntityManagerQueRango() {
        return QUERANGO.createEntityManager();
    }
}
