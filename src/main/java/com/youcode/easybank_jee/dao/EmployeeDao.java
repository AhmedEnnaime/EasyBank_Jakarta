package com.youcode.easybank_jee.dao;

import com.youcode.easybank_jee.entities.Client;
import com.youcode.easybank_jee.entities.Employee;

import java.util.List;

public interface EmployeeDao extends IData<Employee, Integer>{

    public List<Client> findByAnyAttribute(String attribute);

}