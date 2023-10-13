package com.youcode.easybank_jee.dao.daoImpl;

import com.youcode.easybank_jee.dao.EmployeeDao;
import com.youcode.easybank_jee.entities.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public Optional<Employee> create(Employee employee) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> update(Integer id, Employee employee) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findByID(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
