<%--
  Created by IntelliJ IDEA.
  User: ahmedennaime
  Date: 17/10/2023
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EasyBank | When Banking meets Minimalist</title>
    <link rel="stylesheet" href="./css/simulation.css" />
</head>
<body>

<header class="header">
    <nav class="nav">
        <img src="./img/icon.png" alt="Bankist logo" class="nav__logo"
             id="logo" data-version-number="3.0" />
        <ul class="nav__links">
            <li class="nav__item"><a class="nav__link" href="${pageContext.servletContext.contextPath}">Home</a>
            </li>
            <li class="nav__item"><a class="nav__link" href="${pageContext.servletContext.contextPath}/clients">Clients</a>
            </li>
            <li class="nav__item"><a class="nav__link" href="${pageContext.servletContext.contextPath}/employees">Employees</a>
            </li>
            <li class="nav__item">

                <a class="nav__link nav__link--btn btn--show-modal" href="${pageContext.servletContext.contextPath}/simulations">Simulate a credit</a>
            </li>
        </ul>
    </nav>

</header>

<div class="ctn">


    <div class="container">
        <div class="sub-container">
            <div class="top-cards-container">
                <div class="active top-card simulation-top-card">
                    <span class="top-card-num">1</span>
                    <p class="top-card-text">Simulate my credit</p>
                </div>

                <div class="top-card info-top-card">
                    <span class="top-card-num">2</span>
                    <p class="top-card-text">My informations</p>
                </div>
            </div>
            <div class="card">
                <div class="card-container">
                    <div class="input-group">
                        <label class="input-label" for="project">My project</label>
                        <select id="project">
                            <option>I need money</option>
                            <option>Financing my used vehicle</option>
                            <option>Managing the unexpected</option>
                            <option>Financing my new vehicle</option>
                            <option>Equipping my home</option>
                        </select>

                    </div>

                    <div class="input-group">
                        <label class="input-label" for="job">I am</label>
                        <select id="job">
                            <option>Civil servant</option>
                            <option>Liberal profession</option>
                            <option>Retailer</option>
                            <option>Artisan</option>
                            <option>Retired</option>
                            <option>Others</option>
                        </select>

                    </div>

                    <div class="input-group">
                        <div class="first-row">
                            <label class="input-label" for="amount">Amount</label>
                            <span class="range-value amount-value">1000</span>
                        </div>
                        <input class="range-inputs" type="range" id="amount" min="1000" max="600000" value="1000">
                    </div>

                    <div class="input-group">
                        <div class="first-row">
                            <label class="input-label" for="months">Months</label>
                            <span class="range-value months-value">1</span>
                        </div>
                        <input class="range-inputs" type="range" id="months" min="1" max="120" value="1">
                    </div>

                    <div class="input-group">
                        <label class="input-label" for="monthly_payment">Monthly payment</label>
                        <input type="text" id="monthly_payment" disabled>
                    </div>


                </div>

                <div class="btn-div">
                    <button class="next-btn">Next</button>
                </div>

            </div>

            <div class="info-card hidden">
                <div class="card-container">
                    <form class="info-form">
                        <div class="input-group">
                            <label class="input-label" for="employee">Employee</label>
                            <select id="employee">
                                <option value="">Select employee</option>
                                <c:forEach var="employee" items="${employees}">
                                    <option value="${employee.matricule}">${employee.firstName}  ${employee.lastName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="input-group">
                            <label class="input-label" for="client">Client</label>
                            <select id="client">
                                <option value="">Select client</option>
                                <c:forEach var="client" items="${clients}">
                                    <option data-birthDate="${client.birthDate}" data-address="${client.address}" value="${client.code}">${client.firstName}  ${client.lastName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <a class="create-client-link" href="${pageContext.servletContext.contextPath}/clients">Not a client ? Be one now</a>
                    </form>

                </div>

                <div class="validation-div">
                    <button class="back-btn">Back</button>
                    <button class="validate-btn">Validate</button>
                </div>

            </div>

        </div>

    </div>

    <div class="recap-ctn">
        <div class="recap-content">
            <h1 class="recap-title">Summary</h1>
            <div class="recap-group">
                <h3 class="recap-subtitle">My project</h3>
                <span id="recap-text" class="recap-text">Personal</span>
            </div>

            <div class="recap-group client-details hidden">
                <h3 class="recap-subtitle">Client Information</h3>
                <div class="recap-info">
                    <span class="recap-text">First Name</span>
                    <p id="client-firstName" class="recap-info-val"></p>
                </div>

                <div class="recap-info">
                    <span class="recap-text">Last Name</span>
                    <p id="client-lastName" class="recap-info-val"></p>
                </div>

                <div class="recap-info">
                    <span class="recap-text">BirthDate</span>
                    <p id="client-birthDate" class="recap-info-val"></p>
                </div>

                <div class="recap-info">
                    <span class="recap-text">Address</span>
                    <p id="client-address" class="recap-info-val"></p>
                </div>

            </div>

            <div class="recap-group credit-details hidden">
                <h3 class="recap-subtitle">Credit Details</h3>

                <div class="recap-info">
                    <span class="recap-text">You are</span>
                    <p id="client_job" class="recap-info-val">Retailer</p>
                </div>

                <div class="recap-info">
                    <span class="recap-text">Amount</span>
                    <p id="amount-recap" class="recap-info-val"></p>
                </div>

                <div class="recap-info">
                    <span class="recap-text">Duration</span>
                    <p id="duration" class="recap-info-val"></p>
                </div>

                <div class="recap-info">
                    <span class="recap-text">Monthly payment</span>
                    <p id="monthly_payment_recap" class="recap-info-val">14000 DH</p>
                </div>
            </div>

        </div>

    </div>

</div>


<script src="./js/simulation.js"></script>

</body>
</html>
