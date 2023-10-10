package com.youcode.easybank_jee.servlets;

import com.youcode.easybank_jee.entities.Employee;
import com.youcode.easybank_jee.services.EmployeeService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employees")
public class EmployeeServlet extends HttpServlet {

    @Inject
    private EmployeeService employeeService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/employees.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDateStr = request.getParameter("birthdate");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String recruitmentDateStr = request.getParameter("recruitmentDate");

        LocalDate birthDate = LocalDate.parse(birthDateStr);
        LocalDate recruitmentDate = LocalDate.parse(recruitmentDateStr);

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setBirthDate(birthDate);
        employee.setPhone(phone);
        employee.setAddress(address);
        employee.setEmail(email);
        employee.setRecruitmentDate(recruitmentDate);

        try {
            employeeService.createEmployee(employee);
            response.sendRedirect(request.getContextPath() + "/employees");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}