package com.youcode.easybank_jee.dao.daoImpl;

import com.youcode.easybank_jee.dao.EmployeeDao;
import com.youcode.easybank_jee.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDaoImplTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private EntityTransaction transaction;

    @Mock
    private TypedQuery<Employee> query;

    private EmployeeDao employeeDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeDao = new EmployeeDaoImpl(entityManager);
    }

    @Test
    @Transactional
    void testCreateEmployee() {

        Employee employee = new Employee(
                "Mousta",
                "Delegue",
                LocalDate.of(2001, 11, 17),
                "06473347924",
                "Jrayfat",
                LocalDate.of(2023, 9, 21),
                "mousta@gmail.com"
        );

        Mockito.when(entityManager.getTransaction()).thenReturn(transaction);

        Optional<Employee> result = employeeDao.create(employee);

        Mockito.verify(transaction).commit();

        assertTrue(result.isPresent());
        assertSame(result.get(), employee);
    }

    @Test
    @Transactional
    void testFindEmployeeByID() {

        Employee employee = new Employee(
                "Mousta",
                "Delegue",
                LocalDate.of(2001, 11, 17),
                "06473347924",
                "Jrayfat",
                LocalDate.of(2023, 9, 21),
                "mousta@gmail.com"
        );

        int employeeId = 1;

        Mockito.when(entityManager.getTransaction()).thenReturn(transaction);
        Mockito.when(entityManager.find(Employee.class, employeeId)).thenReturn(employee);

        Optional<Employee> result = employeeDao.findByID(employeeId);

        Mockito.verify(transaction).commit();

        assertTrue(result.isPresent());
        assertEquals(employee, result.get());
    }

    @Test
    @Transactional
    void testGetAllEmployees() {
        Employee employee1 = new Employee("Mousta", "Delegue", LocalDate.of(2001, 11, 17), "06473347924", "Jrayfat", LocalDate.of(2023, 9, 21), "mousta@gmail.com");
        Employee employee2 = new Employee("John", "Doe", LocalDate.of(1990, 5, 15), "1234567890", "Address", LocalDate.of(2023, 9, 21), "john@example.com");
        List<Employee> employees = Arrays.asList(employee1, employee2);

        Mockito.when(entityManager.createQuery("SELECT c FROM Employee c", Employee.class)).thenReturn(query);

        Mockito.when(query.getResultList()).thenReturn(employees);

        List<Employee> result = employeeDao.getAll();

        assertTrue(result.containsAll(employees));
        assertEquals(employees.size(), result.size());
    }

    @Test
    void testUpdateEmployee() {

        Employee employee = new Employee(
                "Mousta",
                "Delegue",
                LocalDate.of(2001, 11, 17),
                "06473347924",
                "Jrayfat",
                LocalDate.of(2023, 9, 21),
                "mousta@gmail.com"
        );

        Mockito.when(entityManager.getTransaction()).thenReturn(transaction);
        Mockito.when(entityManager.find(Employee.class, employee.getMatricule())).thenReturn(employee);
        Mockito.when(entityManager.merge(employee)).thenReturn(employee);

        Optional<Employee> result = employeeDao.update(employee);

        Mockito.verify(transaction).commit();

        assertTrue(result.isPresent());
        assertEquals(employee, result.get());
    }

    @Test
    @Transactional
    void testDeleteEmployee() {

        Employee employee = new Employee(
                "Mousta",
                "Delegue",
                LocalDate.of(2001, 11, 17),
                "06473347924",
                "Jrayfat",
                LocalDate.of(2023, 9, 21),
                "mousta@gmail.com"
        );

        int employeeId = 1;

        Mockito.when(entityManager.getTransaction()).thenReturn(transaction);
        Mockito.when(entityManager.find(Employee.class, employeeId)).thenReturn(employee);

        boolean result = employeeDao.delete(employeeId);

        Mockito.verify(transaction).commit();

        assertTrue(result);
    }
}
