//package com.youcode.easybank_jee.dao.daoImpl;
//
//import com.youcode.easybank_jee.entities.Employee;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class EmployeeDaoImplTest {
//
//    private EmployeeDaoImpl employeeDao;
//
//    @Mock
//    private EntityManager entityManager;
//
//    @Mock
//    private TypedQuery<Employee> query;
//
//
//    @BeforeEach
//    public void setup() {
//        employeeDao = new EmployeeDaoImpl(entityManager);
//    }
//
//    @Test
//    public void testGetAll() {
//        List<Employee> expectedEmployees = new ArrayList<>();
//        expectedEmployees.add(new Employee(
//                "Mousta",
//                "Delegue",
//                LocalDate.of(2001, 11, 17),
//                "06473347924",
//                "Jrayfat",
//                LocalDate.of(2023, 9, 21),
//                "mousta@gmail.com"
//        ));
//
//        expectedEmployees.add(new Employee(
//                "Abdelali",
//                "Hotgam",
//                LocalDate.of(2001, 11, 17),
//                "0641237924",
//                "Jrayfat",
//                LocalDate.of(2023, 9, 21),
//                "hotgam@gmail.com"
//        ));
//
//        when(entityManager.createQuery("SELECT e FROM Employee e", Employee.class)).thenReturn(query);
//        when(query.getResultList()).thenReturn(expectedEmployees);
//
//        List<Employee> actualEmployees = employeeDao.getAll();
//
//        verify(entityManager).createQuery("SELECT e FROM Employee e", Employee.class);
//        assertEquals(expectedEmployees, actualEmployees);
//    }
//}
//
