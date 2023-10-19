//package com.youcode.easybank_jee.dao.daoImpl;
//
//import com.youcode.easybank_jee.entities.Client;
//import com.youcode.easybank_jee.utils.JPAUtil;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDate;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class ClientDaoImplTest {
//
//    @InjectMocks
//    private ClientDaoImpl clientDao;
//
//    @Mock
//    private EntityManager entityManager;
//
//    @Mock
//    private EntityTransaction transaction;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        JPAUtil.setEntityManagerFactory(Mockito.mock(EntityManagerFactory.class));
//        Mockito.when(JPAUtil.getEntityManagerFactory().createEntityManager()).thenReturn(entityManager);
//        Mockito.when(entityManager.getTransaction()).thenReturn(transaction);
//    }
//
//    @Test
//    void testCreate() {
//
//        Client client = new Client();
//        client.setFirstName("John");
//        client.setLastName("Doe");
//        client.setPhone("0628738264");
//        client.setAddress("hay anass");
//        client.setBirthDate(LocalDate.now());
//
//        Mockito.when(entityManager.getTransaction()).thenReturn(transaction);
//
//        Mockito.doNothing().when(transaction).begin();
//        Mockito.doNothing().when(entityManager).persist(client);
//        Mockito.doNothing().when(transaction).commit();
//
//        Optional<Client> createdClient = clientDao.create(client);
//
//        assertTrue(createdClient.isPresent());
//
//        assertEquals("John", createdClient.get().getFirstName());
//        assertEquals("Doe", createdClient.get().getLastName());
//    }
//
//    @Test
//    void testCreateFailure() {
//        // Create a sample Client object for testing
//        Client client = new Client();
//        client.setFirstName("John");
//        client.setLastName("Doe");
//
//        // Configure the EntityManager to return a transaction
//        Mockito.when(entityManager.getTransaction()).thenReturn(transaction);
//
//        // Configure the transaction behavior to throw an exception
//        Mockito.doThrow(new RuntimeException("Simulated DB Error")).when(transaction).begin();
//
//        // Call the create method
//        Optional<Client> createdClient = clientDao.create(client);
//
//        // Verify that the client creation failed
//        assertFalse(createdClient.isPresent());
//    }
//}
