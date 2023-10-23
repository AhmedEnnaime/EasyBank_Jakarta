package com.youcode.easybank_jee.services;

import com.youcode.easybank_jee.dao.daoImpl.ClientDaoImpl;
import com.youcode.easybank_jee.entities.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientServiceTest {

    @Mock
    private ClientDaoImpl clientDao;

    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        clientService = new ClientService();
        clientService.setClientDao(clientDao);
    }

    @Test
    public void testCreateClient() {
        Client client = new Client();

        when(clientDao.create(client)).thenReturn(Optional.of(client));

        try {
            Client createdClient = clientService.createClient(client);
            assertSame(client, createdClient);
        }catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testCreateNullClient() {
        try {
            clientService.createClient(null);
            fail("Exception should be thrown for a null employee");
        }catch (Exception e) {
            assertEquals("Client cannot be null", e.getMessage());
        }
    }

    @Test
    public void testFindClientByID() {
        Client client = new Client();

        int clientID = 1;

        when(clientDao.findByID(clientID)).thenReturn(Optional.of(client));
        try {
            Client foundClient = clientService.findClientByID(clientID);
            assertSame(foundClient, client);
        }catch (Exception e) {
            fail("Exception should not be thrown");
        }

        verify(clientDao).findByID(clientID);
    }

    @Test
    public void testFindClientByInvalidID() {
        int invalidClientID = -1;
        try {
            clientService.findClientByID(invalidClientID);
            fail("Invalid ID exception");
        }catch (Exception e) {
            assertEquals("Client id cannot be empty or less than zero", e.getMessage());
        }
    }

    @Test
    public void testGetAllClients() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client());
        clients.add(new Client());

        when(clientDao.getAll()).thenReturn(clients);
        List<Client> result = clientService.getAllClients();
        assertEquals(clients, result);
    }

    @Test
    public void testUpdateClientWithInvalidClient() {
        try {
            clientService.updateClient(null);
            fail("Exception should be thrown for a null client");
        }catch (Exception e) {
            assertEquals("Client cannot be null", e.getMessage());
        }
        verifyNoInteractions(clientDao);
    }

}
