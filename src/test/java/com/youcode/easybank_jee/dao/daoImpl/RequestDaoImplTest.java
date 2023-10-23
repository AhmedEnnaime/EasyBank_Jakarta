//package com.youcode.easybank_jee.dao.daoImpl;
//import com.youcode.easybank_jee.dao.RequestDao;
//import com.youcode.easybank_jee.entities.Request;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.TypedQuery;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//
//public class RequestDaoImplTest {
//
//    private RequestDao requestDao;
//
//    @Mock
//    private EntityManager entityManager;
//
//    @Mock
//    private EntityTransaction transaction;
//
//    @Mock
//    private TypedQuery<Request> query;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        requestDao = new RequestDaoImpl();
//    }
//
//    @Test
//    @Transactional
//    public void testCreate() {
//        Request request = new Request();
//
//        when(entityManager.getTransaction()).thenReturn(transaction);
//        Optional<Request> createdRequest = requestDao.create(request);
//        verify(transaction).commit();
//
//        assertTrue(createdRequest.isPresent());
//        assertSame(createdRequest.get(), request);
//    }
//
//    @Test
//    @Transactional
//    public void testFindById() {
//        Request request = new Request();
//
//        int requestID = 1;
//        when(entityManager.getTransaction()).thenReturn(transaction);
//        when(entityManager.find(Request.class, requestID)).thenReturn(request);
//
//        Optional<Request> retrievedRequest = requestDao.findByID(requestID);
//        verify(transaction).commit();
//
//        assertTrue(retrievedRequest.isPresent());
//        assertSame(request, retrievedRequest.get());
//    }
//
//    @Test
//    @Transactional
//    public void testUpdate() {
//        Request request = new Request();
//
//        when(entityManager.getTransaction()).thenReturn(transaction);
//        when(entityManager.find(Request.class, request.getNumber())).thenReturn(request);
//        when(entityManager.merge(request)).thenReturn(request);
//
//        Optional<Request> updatedRequest = requestDao.update(request);
//        verify(transaction).commit();
//
//        assertTrue(updatedRequest.isPresent());
//        assertEquals(request, updatedRequest.get());
//    }
//
//    @Test
//    @Transactional
//    public void testDelete() {
//        Request request = new Request();
//
//        when(entityManager.getTransaction()).thenReturn(transaction);
//        when(entityManager.find(Request.class, 1)).thenReturn(request);
//
//        boolean result = requestDao.delete(1);
//        verify(transaction).commit();
//        assertTrue(result);
//    }
//
//    @Test
//    @Transactional
//    public void testGetAll() {
//        Request request1 = new Request();
//        Request request2 = new Request();
//
//        List<Request> requests = Arrays.asList(request1, request2);
//        when(entityManager.createQuery("SELECT c FROM Request c", Request.class)).thenReturn(query);
//        when(query.getResultList()).thenReturn(requests);
//
//        List<Request> result = requestDao.getAll();
//        assertTrue(result.containsAll(requests));
//        assertEquals(result.size(), requests.size());
//    }
//}
