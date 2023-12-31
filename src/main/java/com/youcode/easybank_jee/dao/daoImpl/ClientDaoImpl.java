package com.youcode.easybank_jee.dao.daoImpl;

import com.youcode.easybank_jee.dao.ClientDao;
import com.youcode.easybank_jee.entities.Client;
import com.youcode.easybank_jee.utils.JPAUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientDaoImpl implements ClientDao {

    private final EntityManager em;

    public ClientDaoImpl() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    public ClientDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Client> create(Client client) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(client);
            transaction.commit();
            return Optional.of(client);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<Client> update(Client client) {
        Client existingClient = em.find(Client.class, client.getCode());
        EntityTransaction transaction = em.getTransaction();
        if (existingClient != null) {
            existingClient.setLastName(client.getLastName());
            existingClient.setFirstName(client.getFirstName());
            existingClient.setBirthDate(client.getBirthDate());
            existingClient.setPhone(client.getPhone());
            existingClient.setAddress(client.getAddress());
            existingClient.setEmployee(client.getEmployee());

            em.merge(existingClient);
            transaction.commit();
            return Optional.of(existingClient);
        } else {
            transaction.rollback();
            return Optional.empty();
        }
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
            e.printStackTrace();
            return Optional.empty();
        }
    }


    @Override
    public List<Client> getAll() {
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c JOIN FETCH c.employee", Client.class);
        return query.getResultList();
    }

    @Override
    public boolean delete(Integer id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Client client = em.find(Client.class, id);
            if (client != null) {
                em.remove(client);
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
