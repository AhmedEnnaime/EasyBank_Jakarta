package com.youcode.easybank_jee.dao.daoImpl;

import com.youcode.easybank_jee.dao.ClientDao;
import com.youcode.easybank_jee.entities.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ClientDaoImplTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private EntityTransaction transaction;

    @Mock
    private TypedQuery<Client> query;

    private ClientDao clientDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        clientDao = new ClientDaoImpl(entityManager);
    }

    @Test
    @Transactional
    public void testCreateClient() {
        Client client = new Client();

        when(entityManager.getTransaction()).thenReturn(transaction);

        Optional<Client> createdClient = clientDao.create(client);

        verify(transaction).commit();

        assertTrue(createdClient.isPresent());
        assertSame(createdClient.get(), client);
    }

    @Test
    @Transactional
    public void testFindByID() {
        Client client = new Client();

        int clientID = 1;
        when(entityManager.getTransaction()).thenReturn(transaction);
        when(entityManager.find(Client.class, clientID)).thenReturn(client);

        Optional<Client> retrievedClient = clientDao.findByID(clientID);
        verify(transaction).commit();

        assertTrue(retrievedClient.isPresent());
        assertSame(client, retrievedClient.get());

    }

//    @Test
//    @Transactional
//    public void testGetAllClients() {
//        Client client1 = new Client("John", "Doe", LocalDate.of(1985, 5, 15), "0628738264", "Address 1");
//        Client client2 = new Client("Alice", "Smith", LocalDate.of(1990, 3, 20), "0791234567", "Address 2");
//        List<Client> clients = Arrays.asList(client1, client2);
//
//        when(entityManager.createQuery("SELECT c FROM Client c", Client.class)).thenReturn(query);
//        when(query.getResultList()).thenReturn(clients);
//
//        List<Client> result = clientDao.getAll();
//
//        assertTrue(result.containsAll(clients));
//        assertEquals(clients.size(), result.size());
//    }

    @Test
    @Transactional
    public void testUpdate() {
        Client client = new Client();

        when(entityManager.getTransaction()).thenReturn(transaction);
        when(entityManager.find(Client.class, client.getCode())).thenReturn(client);
        when(entityManager.merge(client)).thenReturn(client);

        Optional<Client> result = clientDao.update(client);
        verify(transaction).commit();

        assertTrue(result.isPresent());
        assertEquals(client, result.get());
    }


    @Test
    @Transactional
    public void testDelete() {
        Client client = new Client();

        int clientID = 1;
        when(entityManager.getTransaction()).thenReturn(transaction);
        when(entityManager.find(Client.class, clientID)).thenReturn(client);

        boolean result = clientDao.delete(clientID);
        verify(transaction).commit();
        assertTrue(result);
    }

 }
