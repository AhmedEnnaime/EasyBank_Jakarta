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
    <script src="./js/simulation.js"></script>
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


</body>
</html>
