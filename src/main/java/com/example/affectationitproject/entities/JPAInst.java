package com.example.affectationitproject.entities;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAInst {
    private static final String PERSISTENCE_UNIT_NAME = "Affectation";
    private static EntityManagerFactory factory;
    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }
    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }

}
