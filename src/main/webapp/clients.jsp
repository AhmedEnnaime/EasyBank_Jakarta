<%--
  Created by IntelliJ IDEA.
  User: ahmedennaime
  Date: 11/10/2023
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Clients</title>
    <link rel="stylesheet" href="./css/clients.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<header class="header">
    <nav class="nav">
        <img src="./img/icon.png" alt="Bankist logo" class="nav__logo"
             id="logo" data-version-number="3.0" />
        <ul class="nav__links">
            <li class="nav__item"><a class="nav__link" href="${pageContext.servletContext.contextPath}/clients">Clients</a></li>
            <li class="nav__item"><a class="nav__link" href="${pageContext.servletContext.contextPath}/employees">Employees</a></li>
            <li class="nav__item">
                <a class="nav__link nav__link--btn btn--show-modal" href="#">Open account</a>
            </li>
        </ul>
    </nav>
</header>
<div class="content">
    <button class="add-button">Add Client</button>
    <div class="search-container">
        <form action="${pageContext.request.contextPath}/clients?action=search" method="POST">
            <input type="search" id="clientSearch" name="code" placeholder="Search by code...">
        </form>
    </div>
    <table>
        <thead>
        <tr>
            <th>Client Code</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Birthdate</th>
            <th>Phone</th>
            <th>Address</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="client" items="${clients}" >
            <tr>
                <td>${client.code}</td>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.birthDate}</td>
                <td>${client.phone}</td>
                <td>${client.address}</td>
                <td>
                    <button class="update-button">Update</button>
                    <button class="delete-button" data-clientcode="${client.code}">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div id="clientModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
            <h2>Add Client</h2>
        <form action="${pageContext.request.contextPath}/clients?action=insert" method="POST">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" required><br>

            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" required><br>

            <label for="birthdate">Birthdate:</label>
            <input type="date" id="birthdate" name="birthdate" required><br>

            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone" required><br>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required><br>

            <div class="form-group">
                <button type="submit" name="action" class="submit-button">Add Client</button>
            </div>
        </form>
    </div>
</div>

<div id="updateClientModal" class="modal">
    <div class="modal-content">
        <span class="close-update">&times;</span>
        <h2>Update Client</h2>
        <form action="${pageContext.request.contextPath}/clients?action=update" method="POST">

            <input type="hidden" id="updateClientId" name="clientId">

            <label for="updateFirstName">First Name:</label>
            <input type="text" id="updateFirstName" name="firstName" required><br>

            <label for="updateLastName">Last Name:</label>
            <input type="text" id="updateLastName" name="lastName" required><br>

            <label for="updateBirthdate">Birthdate:</label>
            <input type="date" id="updateBirthdate" name="birthdate" required><br>

            <label for="updatePhone">Phone:</label>
            <input type="tel" id="updatePhone" name="phone" required><br>

            <label for="updateAddress">Address:</label>
            <input type="text" id="updateAddress" name="address" required><br>

            <div class="form-group">
                <button type="submit" name="action" class="submit-button">Update Client</button>
            </div>
        </form>
    </div>
</div>

<div id="deleteClientModal" class="modal">
    <div class="modal-content delete-modal">
        <h2>Delete Client</h2>
        <p>Are you sure you want to delete this client ?</p>
        <form action="${pageContext.request.contextPath}/clients?action=delete" method="POST">
            <input type="hidden" id="deleteClientId" name="deleteClientId">
            <div class="form-group">
                <button type="submit" name="action" class="delete-button">Delete</button>
                <button type="button" class="cancel-button">Cancel</button>
            </div>
        </form>
    </div>
</div>


<script>
    document.addEventListener("DOMContentLoaded", function() {
        const deleteButtons = document.querySelectorAll(".delete-button");
        const cancelButtons = document.querySelectorAll(".cancel-button");
        const addClientButton = document.querySelector(".add-button");
        const closeButtons = document.querySelectorAll(".close, .modal");
        const modalContents = document.querySelectorAll(".modal-content");
        const updateButtons = document.querySelectorAll(".update-button");
        const closeUpdateButtons = document.querySelectorAll(".close-update, #updateClientModal");

        const deleteClientModal = document.getElementById("deleteClientModal");
        const deleteClientIdInput = document.getElementById("deleteClientId");
        const clientModal = document.getElementById("clientModal");
        const updateClientModal = document.getElementById("updateClientModal");

        addClientButton.addEventListener("click", function() {
            console.log("Add Client button clicked");
            clientModal.style.display = "block";
        });

        closeButtons.forEach(function(button) {
            button.addEventListener("click", function() {
                clientModal.style.display = "none";
            });
        });

        modalContents.forEach(function(content) {
            content.addEventListener("click", function(event) {
                event.stopPropagation();
            });
        });

        updateButtons.forEach(function(button) {
            button.addEventListener("click", function() {
                console.log("update clicked");
                const row = button.closest("tr");
                const clientId = row.querySelector("td:first-child").textContent;
                const firstName = row.querySelector("td:nth-child(2)").textContent;
                const lastName = row.querySelector("td:nth-child(3)").textContent;
                const birthdate = row.querySelector("td:nth-child(4)").textContent;
                const phone = row.querySelector("td:nth-child(5)").textContent;
                const address = row.querySelector("td:nth-child(6)").textContent;

                const updateClientIdInput = document.getElementById("updateClientId");
                const updateFirstNameInput = document.getElementById("updateFirstName");
                const updateLastNameInput = document.getElementById("updateLastName");
                const updateBirthdateInput = document.getElementById("updateBirthdate");
                const updatePhoneInput = document.getElementById("updatePhone");
                const updateAddressInput = document.getElementById("updateAddress");

                updateClientIdInput.value = clientId;
                updateFirstNameInput.value = firstName;
                updateLastNameInput.value = lastName;
                updateBirthdateInput.value = birthdate;
                updatePhoneInput.value = phone;
                updateAddressInput.value = address;

                updateClientModal.style.display = "block";
            });
        });

        closeUpdateButtons.forEach(function(button) {
            button.addEventListener("click", function() {
                updateClientModal.style.display = "none";
            });
        });

        deleteButtons.forEach(function(button) {
            button.addEventListener("click", function() {
                const row = button.closest("tr");
                const clientId = row.querySelector("td:first-child").textContent;
                deleteClientIdInput.value = clientId;
                deleteClientModal.style.display = "block";
            });
        });

        cancelButtons.forEach(function(button) {
            button.addEventListener("click", function() {
                deleteClientModal.style.display = "none";
            });
        });
    });
</script>

</body>
</html>

