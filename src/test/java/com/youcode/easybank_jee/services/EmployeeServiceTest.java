package com.youcode.easybank_jee.services;

import com.youcode.easybank_jee.dao.daoImpl.EmployeeDaoImpl;
import com.youcode.easybank_jee.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeDaoImpl employeeDao;

    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService();
        employeeService.setEmployeeDao(employeeDao);
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee();

        when(employeeDao.create(employee)).thenReturn(Optional.of(employee));

        try {
            Employee createdEmployee = employeeService.createEmployee(employee);
            assertSame(employee, createdEmployee);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        verify(employeeDao).create(employee);
    }

    @Test
    public void testCreateEmployeeWithNullEmployee() {
        try {
            employeeService.createEmployee(null);
            fail("Exception should be thrown for a null employee");
        } catch (Exception e) {
            assertEquals("Employee cannot be null", e.getMessage());
        }

        verifyNoInteractions(employeeDao);
    }

    @Test
    public void testFindEmployeeByID() {
        Employee employee = new Employee();
        int employeeId = 1;

        when(employeeDao.findByID(employeeId)).thenReturn(Optional.of(employee));

        try {
            Employee foundEmployee = employeeService.findEmployeeByID(employeeId);
            assertSame(employee, foundEmployee);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        verify(employeeDao).findByID(employeeId);
    }

    @Test
    void testFindEmployeeByIDWithInvalidID() {
        int invalidEmployeeId = -1;

        try {
            employeeService.findEmployeeByID(invalidEmployeeId);
            fail("Invalid ID exception");
        } catch (Exception e) {
            assertEquals("Employee id cannot be empty or less than zero", e.getMessage());
        }

        verifyNoInteractions(employeeDao);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employees.add(new Employee());

        when(employeeDao.getAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(employees, result);
    }

//    @Test
//    public void testDeleteEmployee() {
//        int employeeId = 1;
//        when(employeeDao.delete(employeeId)).thenReturn(true);
//        boolean result = employeeService.deleteEmployee(employeeId);
//        assertTrue(result);
//        verify(employeeDao).delete(employeeId);
//    }

//    @Test
//    public void testUpdateEmployeeWithValidEmployee() {
//        Employee employee = new Employee();
//        when(employeeDao.update(employee)).thenReturn(Optional.of(employee));
//
//        try {
//            employeeService.updateEmployee(employee);
//            verify(employeeDao).update(employee);
//        } catch (Exception e) {
//            fail(e.getMessage());
//        }
//    }


    @Test
    public void testUpdateEmployeeWithInvalidEmployee() {
        try {
            employeeService.updateEmployee(null);
            fail("Exception should be thrown for a null employee");
        } catch (Exception e) {
            assertEquals("Employee cannot be null", e.getMessage());
        }
        verifyNoInteractions(employeeDao);
    }

//    @Test
//    public void testUpdateEmployeeWithInvalidEmployeeId() {
//        Employee employee = new Employee();
//        employee.setMatricule(-1);
//
//        try {
//            employeeService.updateEmployee(employee);
//            fail("Exception should be thrown for an employee with an invalid ID");
//        } catch (Exception e) {
//            assertEquals("Employee not found, please check if the ID is valid", e.getMessage());
//        }
//
//        verifyNoInteractions(employeeDao);
//    }



}
