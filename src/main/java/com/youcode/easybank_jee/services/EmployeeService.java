package com.youcode.easybank_jee.services;

import com.youcode.easybank_jee.dao.daoImpl.EmployeeDaoImpl;
import com.youcode.easybank_jee.entities.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EmployeeService {

    @Inject
    private EmployeeDaoImpl employeeDao;

    public void setEmployeeDao(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }


    public Employee createEmployee(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("Employee cannot be null");
        }else {
            return employeeDao.create(employee).get();
        }
    }

    public boolean deleteEmployee(Integer id) {
        Optional<Employee> retrievedEmployee = employeeDao.findByID(id);
        if (retrievedEmployee.isPresent()) {
            return employeeDao.delete(id);
        }else {
            return false;
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
        if (employee == null) {
            throw new Exception("Employee cannot be null");
        }
        Optional<Employee> retrievedEmployee = employeeDao.findByID(employee.getMatricule());
        if (retrievedEmployee.isPresent()) {
            throw new Exception("Employee not found, please check if the ID is valid");
        } else {
            employeeDao.update(employee).get();
        }
    }

}
