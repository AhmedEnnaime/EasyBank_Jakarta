<%--
  Created by IntelliJ IDEA.
  User: ahmedennaime
  Date: 17/10/2023
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <div class="top-card">
                    <span class="top-card-num">1</span>
                    <p class="top-card-text">Simulate my credit</p>
                </div>

                <div class="top-card">
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
                            <option>I need money</option>
                            <option>I need money</option>
                        </select>

                    </div>

                    <div class="input-group">
                        <label class="input-label" for="job">I am</label>
                        <select id="job">
                            <option>Professional</option>
                            <option>Professional</option>
                            <option>Professional</option>
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
                        <input value="5600" type="text" id="monthly_payment" disabled>
                    </div>


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

            <div class="recap-group">
                <h3 class="recap-subtitle">Client Information</h3>
                <div class="recap-info">
                    <span class="recap-text">Email</span>
                    <p class="recap-info-val">ahmedennaime@gmail.com</p>
                </div>

                <div class="recap-info">
                    <span class="recap-text">First Name</span>
                    <p class="recap-info-val">Ahmed</p>
                </div>

                <div class="recap-info">
                    <span class="recap-text">Last Name</span>
                    <p class="recap-info-val">Ennaime</p>
                </div>

            </div>

        </div>

    </div>

</div>


<script src="./js/simulation.js"></script>

</body>
</html>
