package com.youcode.easybank_jee.servlets;

import com.youcode.easybank_jee.entities.Client;
import com.youcode.easybank_jee.entities.Employee;
import com.youcode.easybank_jee.services.ClientService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClientServlet", value = "/clients")
public class ClientServlet extends HttpServlet {

    @Inject
    private ClientService clientService;

    private void getClients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = clientService.getAllClients();
        request.setAttribute("clients", clients);
        request.getRequestDispatcher("/clients.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getClients(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}