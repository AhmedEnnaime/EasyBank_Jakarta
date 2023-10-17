package com.youcode.easybank_jee.dao.daoImpl;

import com.youcode.easybank_jee.dao.EmployeeDao;
import com.youcode.easybank_jee.entities.Client;
import com.youcode.easybank_jee.entities.Employee;
import com.youcode.easybank_jee.utils.JPAUtil;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

    public EmployeeDaoImpl(EntityManager em) {
        em.getTransaction().begin();
    }

    @Override
    public Optional<Employee> create(Employee employee) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> update(Employee employee) {
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

    @Override
    public List<Client> findByAnyAttribute(String attribute) {
        return null;
    }
}
