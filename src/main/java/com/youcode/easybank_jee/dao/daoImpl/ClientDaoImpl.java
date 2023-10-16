package com.youcode.easybank_jee.dao.daoImpl;

import com.youcode.easybank_jee.dao.ClientDao;
import com.youcode.easybank_jee.entities.Client;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientDaoImpl implements ClientDao {
    @Override
    public Optional<Client> create(Client client) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> update(Integer id, Client client) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> findByID(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Client> getAll() {
        return null;
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
