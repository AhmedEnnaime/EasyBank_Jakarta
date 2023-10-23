package com.youcode.easybank_jee.services;

import com.youcode.easybank_jee.dao.daoImpl.RequestDaoImpl;
import com.youcode.easybank_jee.entities.Request;
import com.youcode.easybank_jee.enums.STATE;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RequestServiceTest {

    @Mock
    private RequestDaoImpl requestDao;

    private RequestService requestService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        requestService = new RequestService();
        requestService.setRequestDao(requestDao);
    }

    @Test
    public void testCreateRequest() {
        Request request = new Request();

        when(requestDao.create(request)).thenReturn(Optional.of(request));

        try {
            Request createdRequest = requestService.createRequest(request);
            assertSame(request, createdRequest);
        }catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testFindByID() {
        Request request = new Request();

        int requestID = 1;

        when(requestDao.findByID(requestID)).thenReturn(Optional.of(request));

        try {
            Request foundRequest = requestService.getRequestByID(requestID);
            assertSame(request, foundRequest);
        }catch (Exception e) {
            fail("Exception should not be thrown");
        }
        verify(requestDao).findByID(requestID);
    }

    @Test
    public void testGetAllRequests() {
        List<Request> requests = new ArrayList<>();
        requests.add(new Request());
        requests.add(new Request());

        when(requestDao.getAll()).thenReturn(requests);
        List<Request> result = requestService.getAllRequests();
        assertEquals(requests, result);
    }

    @Test
    public void testUpdateRequestState() {
        int requestNumber = 1;
        STATE newState = STATE.APPROVED;

        when(requestDao.findByID(requestNumber)).thenReturn(Optional.of(new Request()));

        when(requestDao.updateState(requestNumber, newState)).thenReturn(true);

        boolean result = requestService.updateRequestState(requestNumber, newState);

        assertTrue(result);

        verify(requestDao).findByID(requestNumber);
        verify(requestDao).updateState(requestNumber, newState);
    }

    @Test
    public void testUpdateRequestStateWithInvalidRequestNumber() {
        int invalidRequestNumber = -1;
        STATE newState = STATE.APPROVED;

        when(requestDao.findByID(invalidRequestNumber)).thenReturn(Optional.empty());

        boolean result = requestService.updateRequestState(invalidRequestNumber, newState);

        assertFalse(result);

        verify(requestDao).findByID(invalidRequestNumber);
    }

}
