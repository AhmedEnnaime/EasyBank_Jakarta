package com.youcode.easybank_jee.dao.daoImpl;

import com.youcode.easybank_jee.dao.ClientDao;
import com.youcode.easybank_jee.entities.Client;
import com.youcode.easybank_jee.utils.JPAUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientDaoImpl implements ClientDao {

    private final EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

//    public ClientDaoImpl() {
//        em.getTransaction().begin();
//    }

    @Override
    public Optional<Client> create(Client client) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(client);
            transaction.commit();
            return Optional.of(client);
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Client> update(Integer id, Client client) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> findByID(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Client client = em.find(Client.class, id);
            transaction.commit();

            return Optional.ofNullable(client);
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return Optional.empty();
        }
    }


    @Override
    public List<Client> getAll() {
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Client> findByAnyAttribute(String attribute) {
        return null;
    }
}
