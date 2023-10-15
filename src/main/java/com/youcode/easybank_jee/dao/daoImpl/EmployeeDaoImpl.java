package com.youcode.easybank_jee.dao.daoImpl;

import com.youcode.easybank_jee.dao.EmployeeDao;
import com.youcode.easybank_jee.entities.Client;
import com.youcode.easybank_jee.entities.Employee;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Stateless
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager em;

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
        String jpql = "SELECT e FROM Employee e";
        return em.createQuery(jpql, Employee.class).getResultList();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Client> findByAnyAttribute(String attribute) {
        return null;
    }
}
