package com.youcode.easybank_jee.dao.daoImpl;
import com.youcode.easybank_jee.dao.RequestDao;
import com.youcode.easybank_jee.entities.Request;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class RequestDaoImplTest {

    private RequestDao requestDao;

    @Mock
    private EntityManager entityManager;

    @Mock
    private EntityTransaction transaction;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        requestDao = new RequestDaoImpl();
    }

    @Test
    @Transactional
    public void testCreate() {
        Request request = new Request();

        when(entityManager.getTransaction()).thenReturn(transaction);
        Optional<Request> createdRequest = requestDao.create(request);
        verify(transaction).commit();

        assertTrue(createdRequest.isPresent());
        assertSame(createdRequest.get(), request);
    }

    @Test
    @Transactional
    public void testFindById() {
        Request request = new Request();

        int requestID = 1;
        when(entityManager.getTransaction()).thenReturn(transaction);
        when(entityManager.find(Request.class, requestID)).thenReturn(request);

        Optional<Request> retrievedRequest = requestDao.findByID(requestID);
        verify(transaction).commit();

        assertTrue(retrievedRequest.isPresent());
        assertSame(request, retrievedRequest.get());
    }

    public void testUpdate() {

    }
}
