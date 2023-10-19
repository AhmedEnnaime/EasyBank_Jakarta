package com.youcode.easybank_jee.dao;

import com.youcode.easybank_jee.entities.Client;
import com.youcode.easybank_jee.entities.Request;
import com.youcode.easybank_jee.enums.STATE;

import java.util.Optional;

public interface RequestDao extends IData<Request, Integer>{

    public boolean updateState(Integer id, STATE state);

}
