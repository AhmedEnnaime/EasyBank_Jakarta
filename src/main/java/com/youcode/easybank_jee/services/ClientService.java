package com.youcode.easybank_jee.services;

import com.youcode.easybank_jee.dao.daoImpl.ClientDaoImpl;
import com.youcode.easybank_jee.entities.Client;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ClientService {

    @Inject
    private ClientDaoImpl clientDao;

    public void createClient(Client client) throws Exception {
        if (client == null) {
            throw new Exception("Client cannot be null");
        }else {
            clientDao.create(client).get();
        }
    }

    public boolean deleteClient(Integer id) {
        if (id.toString().isEmpty() || clientDao.findByID(id).isEmpty()) {
            return false;
        }else {
            return clientDao.delete(id);
        }
    }

    public Client findClientByID(Integer id) throws Exception {
        if (id.toString().isEmpty() || id <= 0) {
            throw new Exception("Client id cannot be empty or less than zero");
        }else {
            return clientDao.findByID(id).orElse(null);
        }
    }

    public List<Client> getAllClients() {
        return clientDao.getAll();
    }

    public Client updateClient(Client client) throws Exception {
        if (clientDao.findByID(client.getCode()).isEmpty()) {
            throw new Exception("Client cannot be null check out again if the id is valid");
        }else {
            return clientDao.update(client).get();
        }
    }
}
