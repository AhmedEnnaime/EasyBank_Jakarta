package com.youcode.easybank_jee.servlets;

import com.youcode.easybank_jee.entities.Client;
import com.youcode.easybank_jee.entities.Employee;
import com.youcode.easybank_jee.services.ClientService;
import com.youcode.easybank_jee.services.EmployeeService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SimulationServlet", value = "/simulations")
public class SimulationServlet extends HttpServlet {

    @Inject
    private ClientService clientService;

    @Inject
    private EmployeeService employeeService;


    private void getEmployeesAndClients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = clientService.getAllClients();
        request.setAttribute("clients", clients);

        List<Employee> employees = employeeService.getAllEmployees();
        request.setAttribute("employees", employees);

        request.getRequestDispatcher("/simulation.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getEmployeesAndClients(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}