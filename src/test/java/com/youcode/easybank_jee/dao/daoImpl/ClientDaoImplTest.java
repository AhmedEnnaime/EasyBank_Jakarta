package com.youcode.easybank_jee.dao.daoImpl;

import com.youcode.easybank_jee.dao.ClientDao;
import com.youcode.easybank_jee.entities.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ClientDaoImplTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private EntityTransaction transaction;

    private ClientDao clientDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clientDao = new ClientDaoImpl(entityManager);
    }

    @Test
    @Transactional
    void testCreateClient() {
        Client client = new Client();
        client.setFirstName("John");
        client.setLastName("Doe");
        client.setPhone("0628738264");
        client.setAddress("hay anass");
        client.setBirthDate(LocalDate.now());

        Mockito.when(entityManager.getTransaction()).thenReturn(transaction);

        Optional<Client> createdClient = clientDao.create(client);

        Mockito.verify(transaction).commit();

        assertTrue(createdClient.isPresent());
        assertSame(createdClient.get(), client);
    }
}
