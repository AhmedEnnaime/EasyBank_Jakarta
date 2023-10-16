package com.youcode.easybank_jee.dao.daoImpl;

import com.youcode.easybank_jee.dao.RequestDao;
import com.youcode.easybank_jee.entities.Client;
import com.youcode.easybank_jee.entities.Request;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RequestDaoImpl implements RequestDao {
    @Override
    public Optional<Request> create(Request request) {
        return Optional.empty();
    }

    @Override
    public Optional<Request> update(Request request) {
        return Optional.empty();
    }

    @Override
    public Optional<Request> findByID(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Request> getAll() {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Optional<Request> findByClient(Client client) {
        return Optional.empty();
    }
}
