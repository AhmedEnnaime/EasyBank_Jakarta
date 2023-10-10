<%--
  Created by IntelliJ IDEA.
  User: ahmedennaime
  Date: 10/10/2023
  Time: 09:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees</title>
    <link rel="stylesheet" href="./css/employees.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<header class="header">
    <nav class="nav">
        <img src="./img/icon.png" alt="Bankist logo" class="nav__logo"
             id="logo" data-version-number="3.0" />
        <ul class="nav__links">
            <li class="nav__item"><a class="nav__link" href="#">Clients</a>
            </li>
            <li class="nav__item"><a class="nav__link" href="#">Employees</a>
            </li>
            <li class="nav__item">

                <a class="nav__link nav__link--btn btn--show-modal" href="#">Open
                    account</a>
            </li>
        </ul>
    </nav>
</header>
<div class="content">
    <button class="add-button">Add employee</button>
    <div class="search-container">
        <input type="search" id="employeeSearch" placeholder="Search by last name...">

    </div>
    <table>
        <thead>
        <tr>
            <th>Matricule</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Birthdate</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Email</th>
            <th>Recruitment date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employees}" >
            <tr>
                <td>${employee.matricule}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.birthDate}</td>
                <td>${employee.phone}</td>
                <td>${employee.address}</td>
                <td>${employee.email}</td>
                <td>${employee.recruitmentDate}</td>
                <td>
                    <button class="update-button">Update</button>
                    <button class="delete-button">Delete</button>
                </td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
</div>

<div id="employeeModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h2>Add Employee</h2>
        <form action="${pageContext.request.contextPath}/employees" method="POST">
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

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>

            <label for="recruitmentDate">Recruitment Date:</label>
            <input type="date" id="recruitmentDate" name="recruitmentDate" required><br>

            <div class="form-group">
                <button type="submit" class="submit-button">Add Employee</button>
            </div>
        </form>
    </div>
</div>


<div id="updateEmployeeModal" class="modal">
    <div class="modal-content">
        <span class="close-update">&times;</span>
        <h2>Update Employee</h2>
        <form action="" method="POST">

            <input type="hidden" id="updateEmployeeId" name="employeeId">

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

            <label for="updateEmail">Email:</label>
            <input type="email" id="updateEmail" name="email" required><br>

            <label for="updateRecruitmentDate">Recruitment Date:</label>
            <input type="date" id="updateRecruitmentDate" name="recruitmentDate" required><br>

            <div class="form-group">
                <button type="submit" class="submit-button">Update Employee</button>
            </div>
        </form>
    </div>
</div>

<script>
    $(document).ready(function() {
        $("#employeeSearch").on("input", function() {
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
    });
</script>


<script>
    $(document).ready(function() {
        $(".add-button").click(function() {
            $("#employeeModal").css("display", "block");
        });

        $(".close, .modal").click(function() {
            $("#employeeModal").css("display", "none");
        });

        $(".modal-content").click(function(event) {
            event.stopPropagation();
        });
    });
</script>

<script>
    $(document).ready(function() {

        $(".update-button").click(function() {
            const row = $(this).closest("tr");
            const employeeId = row.find("td:first").text();
            const firstName = row.find("td:nth-child(2)").text();
            const lastName = row.find("td:nth-child(3)").text();
            const birthdate = row.find("td:nth-child(4)").text();
            const phone = row.find("td:nth-child(5)").text();
            const address = row.find("td:nth-child(6)").text();
            const email = row.find("td:nth-child(7)").text();
            const recruitmentDate = row.find("td:nth-child(8)").text();

            $("#updateEmployeeId").val(employeeId);
            $("#updateFirstName").val(firstName);
            $("#updateLastName").val(lastName);
            $("#updateBirthdate").val(birthdate);
            $("#updatePhone").val(phone);
            $("#updateAddress").val(address);
            $("#updateEmail").val(email);
            $("#updateRecruitmentDate").val(recruitmentDate);

            $("#updateEmployeeModal").css("display", "block");
        });

        $(".close-update, #updateEmployeeModal").click(function() {
            $("#updateEmployeeModal").css("display", "none");
        });

        $(".modal-content").click(function(event) {
            event.stopPropagation();
        });
    });

</script>

</body>
</html>
