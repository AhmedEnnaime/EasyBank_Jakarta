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


    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("employeeId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDateStr = request.getParameter("birthdate");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String recruitmentDateStr = request.getParameter("recruitmentDate");

        LocalDate birthDate = LocalDate.parse(birthDateStr);
        LocalDate recruitmentDate = LocalDate.parse(recruitmentDateStr);

        Employee updatedEmployee = new Employee();
        updatedEmployee.setFirstName(firstName);
        updatedEmployee.setLastName(lastName);
        updatedEmployee.setBirthDate(birthDate);
        updatedEmployee.setPhone(phone);
        updatedEmployee.setAddress(address);
        updatedEmployee.setEmail(email);
        updatedEmployee.setRecruitmentDate(recruitmentDate);

        try {
            employeeService.updateEmployee(id, updatedEmployee);
            response.sendRedirect(request.getContextPath() + "/employees");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/employees.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HERE WE GO");
        System.out.println("param id " + request.getParameter("deleteEmployeeId"));
        int id = Integer.parseInt(request.getParameter("deleteEmployeeId"));
        boolean isDeleted = employeeService.deleteEmployee(id);
        if (isDeleted) {
            response.sendRedirect(request.getContextPath() + "/employees");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       getEmployees(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "insert" :
                insertEmployee(request, response);
                break;
            case "update" :
                updateEmployee(request, response);
                break;
            case "delete" :
                deleteEmployee(request, response);
                break;
        }

    }

}