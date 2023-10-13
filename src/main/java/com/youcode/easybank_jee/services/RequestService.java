package com.youcode.easybank_jee.services;

import com.youcode.easybank_jee.dao.RequestDao;
import com.youcode.easybank_jee.entities.Request;
import com.youcode.easybank_jee.enums.STATE;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class RequestService {

    @Inject
    private RequestDao requestDao;

    public Request createRequest(Request request) {
        Optional<Request> optionalRequest = requestDao.create(request);
        return optionalRequest.orElse(null);
    }

    public Request getRequestByID(Integer number) {
        Optional<Request> retrievedRequest = requestDao.findByID(number);
        return retrievedRequest.orElse(null);
    }

    public List<Request> getAllRequests() {
        return requestDao.getAll();
    }

//    public boolean updateRequestState(Integer number, STATE state) {
//        if (number.toString().isEmpty() || requestDao.findByID(number).isEmpty()) {
//            return false;
//        }else {
//            return requestDao.updateState(number, state);
//        }
//    }
//
//    public List<Request> getRequestsByState(STATE state) {
//        return requestDao.getByState(state);
//    }
}
