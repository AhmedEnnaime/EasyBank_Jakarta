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
            <li class="nav__item"><a class="nav__link" href="#">Clients</a></li>
            <li class="nav__item"><a class="nav__link" href="#">Employees</a></li>
            <li class="nav__item">
                <a class="nav__link nav__link--btn btn--show-modal" href="#">Open account</a>
            </li>
        </ul>
    </nav>
</header>
<div class="content">
    <button class="add-button">Add Client</button>
    <div class="search-container">
        <input type="search" id="clientSearch" placeholder="Search by last name...">
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
            <th>Employee</th>
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

<script>
    $(document).ready(function() {
        // Show the delete modal when the "Delete" button is clicked
        $(".delete-button").click(function() {
            const row = $(this).closest("tr");
            const clientId = row.find("td:first").text();
            $("#deleteClientId").val(clientId);
            $("#deleteClientModal").css("display", "block");
        });

        // Close the delete modal when the "Cancel" button is clicked
        $(".cancel-button").click(function() {
            $("#deleteClientModal").css("display", "none");
        });

        // Filter the table based on the search input
        $("#clientSearch").on("input", function() {
            const searchText = $(this).val().toLowerCase();
            $(".content table tbody tr").each(function() {
                const lastName = $(this).find("td:nth-child(3)").text().toLowerCase();
                if (lastName.indexOf(searchText) !== -1) {
                    $(this).show();
                } else {
                    $(this).hide();
                }
            });
        });

        // Show the "Add Client" modal when the "Add Client" button is clicked
        $(".add-button").click(function() {
            $("#clientModal").css("display", "block");
        });

        // Close the "Add Client" modal when clicking the close button or outside the modal
        $(".close, .modal").click(function() {
            $("#clientModal").css("display", "none");
        });

        // Prevent modal closing when clicking inside the modal
        $(".modal-content").click(function(event) {
            event.stopPropagation();
        });

        // Show the "Update Client" modal when the "Update" button is clicked
        $(".update-button").click(function() {
            const row = $(this).closest("tr");
            const clientId = row.find("td:first").text();
            const firstName = row.find("td:nth-child(2)").text();
            const lastName = row.find("td:nth-child(3)").text();
            const birthdate = row.find("td:nth-child(4)").text();
            const phone = row.find("td:nth-child(5)").text();
            const address = row.find("td:nth-child(6)").text();
            const email = row.find("td:nth-child(7)").text();
            const code = row.find("td:nth-child(8)").text();

            $("#updateClientId").val(clientId);
            $("#updateFirstName").val(firstName);
            $("#updateLastName").val(lastName);
            $("#updateBirthdate").val(birthdate);
            $("#updatePhone").val(phone);
            $("#updateAddress").val(address);
            $("#updateEmail").val(email);
            $("#updateCode").val(code);

            $("#updateClientModal").css("display", "block");
        });

        // Close the "Update Client" modal when clicking the close button or outside the modal
        $(".close-update, #updateClientModal").click(function() {
            $("#updateClientModal").css("display", "none");
        });

        $(".modal-content").click(function(event) {
            event.stopPropagation();
        });
    });
</script>



</body>
</html>

