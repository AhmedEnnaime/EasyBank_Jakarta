package com.youcode.easybank_jee.services;

import com.youcode.easybank_jee.dao.daoImpl.EmployeeDaoImpl;
import com.youcode.easybank_jee.entities.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class EmployeeService {

    @Inject
    private EmployeeDaoImpl employeeDao;


    public Employee createEmployee(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("Employee cannot be null");
        }else {
            return employeeDao.create(employee).get();
        }
    }

    public boolean deleteEmployee(Integer id) {
        if (id.toString().isEmpty() || employeeDao.findByID(id).isEmpty()) {
            return false;
        }else {
            return employeeDao.delete(id);
        }
    }

    public Employee findEmployeeByID(Integer id) throws Exception {
        if (id.toString().isEmpty() || id <= 0) {
            throw new Exception("Employee id cannot be empty or less than zero");
        }else {
            return employeeDao.findByID(id).orElse(null);
        }
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAll();
    }

    public void updateEmployee(Employee employee) throws Exception {
        if (employeeDao.findByID(employee.getMatricule()).isEmpty() || employee == null) {
            throw new Exception("Employee cannot be null check out again if the id is valid");
        }else {
            employeeDao.update(employee).get();
        }
    }
}
