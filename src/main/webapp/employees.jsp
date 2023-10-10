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


</body>
</html>
