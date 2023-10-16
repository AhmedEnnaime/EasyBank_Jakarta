//package com.youcode.easybank_jee.dao.daoImpl;
//
//import com.youcode.easybank_jee.entities.Client;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith(MockitoExtension.class)
//public class ClientDaoImplTest {
//
//    private ClientDaoImpl clientDao;
//
//    private EmployeeDaoImpl employeeDao;
//
//    @Mock
//    private EntityManager entityManager;
//
//    @Mock
//    private TypedQuery<Client> query;
//
//    @BeforeEach
//    public void setup() {
//        clientDao = new ClientDaoImpl();
//        employeeDao = new EmployeeDaoImpl();
//    }
//
//    @Test
//    public void testGetAll() {
//        List<Client> expectedClients = new ArrayList<>();
//
//        expectedClients.add(new Client(
//                "Mousta",
//                "Delegue",
//                LocalDate.of(2001, 11, 17),
//                "06473347924",
//                "Jrayfat",
//                employee
//        ));
//        expectedClients.add(new Client(2, "Jane Smith"));
//
//        when(entityManager.createQuery("SELECT c FROM Client c", Client.class)).thenReturn(query);
//        when(query.getResultList()).thenReturn(expectedClients);
//
//        List<Client> actualClients = clientDao.getAll();
//
//        verify(entityManager).createQuery("SELECT c FROM Client c", Client.class);
//        assertEquals(expectedClients, actualClients);
//    }
//}
