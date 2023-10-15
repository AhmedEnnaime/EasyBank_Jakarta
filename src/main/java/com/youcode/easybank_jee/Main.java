package com.youcode.easybank_jee;

import com.youcode.easybank_jee.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class Main {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
    }
}
