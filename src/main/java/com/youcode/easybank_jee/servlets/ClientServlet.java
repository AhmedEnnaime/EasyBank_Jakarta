package com.youcode.easybank_jee.servlets;

import com.youcode.easybank_jee.entities.Client;
import com.youcode.easybank_jee.entities.Employee;
import com.youcode.easybank_jee.services.ClientService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ClientServlet", value = "/clients")
public class ClientServlet extends HttpServlet {

    @Inject
    private ClientService clientService;

    private void insertClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("INSERT");
        System.out.println(request.getParameter("birthdate"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDateStr = request.getParameter("birthdate");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        LocalDate birthDate = LocalDate.parse(birthDateStr);



        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setBirthDate(birthDate);
        client.setPhone(phone);
        client.setAddress(address);


        try {
            clientService.createClient(client);
            response.sendRedirect(request.getContextPath() + "/clients");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("clientId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDateStr = request.getParameter("birthdate");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        LocalDate birthDate = LocalDate.parse(birthDateStr);

        Client updatedClient = new Client();
        updatedClient.setFirstName(firstName);
        updatedClient.setLastName(lastName);
        updatedClient.setBirthDate(birthDate);
        updatedClient.setPhone(phone);
        updatedClient.setAddress(address);

        try {
            clientService.updateClient(id, updatedClient);
            response.sendRedirect(request.getContextPath() + "/clients");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("deleteClientId"));
        boolean isDeleted = clientService.deleteClient(id);
        if (isDeleted) {
            response.sendRedirect(request.getContextPath() + "/clients");
        }
    }

    private void getClients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = clientService.getAllClients();
        request.setAttribute("clients", clients);
        request.getRequestDispatcher("/clients.jsp").forward(request, response);
    }

    private void findClientByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codeParam = request.getParameter("code");
        if (codeParam != null && !codeParam.isEmpty()) {
            try {
                int code = Integer.parseInt(codeParam);
                Client client = clientService.findClientByID(code);
                if (client != null) {
                    List<Client> clients = new ArrayList<>();
                    clients.add(client);
                    request.setAttribute("clients", clients);
                    request.getRequestDispatcher("/clients.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "No client found with the given code.");
                    request.getRequestDispatcher("/clients.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                request.setAttribute("message", "Invalid code format.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getClients(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "insert":
                insertClient(request, response);
                break;
            case "update":
                updateClient(request, response);
                break;
            case "delete":
                deleteClient(request, response);
                break;
            case "search":
                findClientByID(request, response);
                break;

        }
    }
}