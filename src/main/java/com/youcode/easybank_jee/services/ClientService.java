package com.youcode.easybank_jee.services;

import com.youcode.easybank_jee.dao.daoImpl.ClientDaoImpl;
import com.youcode.easybank_jee.entities.Client;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientService {

    @Inject
    private ClientDaoImpl clientDao;

    public void setClientDao(ClientDaoImpl clientDao) {
        this.clientDao = clientDao;
    }

    public Client createClient(Client client) throws Exception {
        if (client == null) {
            throw new Exception("Client cannot be null");
        }else {
            return clientDao.create(client).get();
        }
    }

    public boolean deleteClient(Integer id) {
        Optional<Client> retrievedClient = clientDao.findByID(id);
        if (retrievedClient.isPresent()) {
            return clientDao.delete(id);
        }else {
            return false;
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

    public void updateClient(Client client) throws Exception {
        if (client == null) {
            throw new Exception("Client cannot be null");
        }
        Optional<Client> retrievedClient = clientDao.findByID(client.getCode());
        if (retrievedClient.isPresent()) {
            clientDao.update(client);
        }else {
            throw new Exception("Client cannot be null check out again if the id is valid");
        }
    }
}
