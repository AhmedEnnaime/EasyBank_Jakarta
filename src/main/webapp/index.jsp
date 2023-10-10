<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>EasyBank | When Banking meets Minimalist</title>
    <link rel="stylesheet" href="./css/index.css" />
</head>
<body>

<header class="header">
    <nav class="nav">
        <img src="./img/icon.png" alt="Bankist logo" class="nav__logo"
             id="logo" data-version-number="3.0" />
        <ul class="nav__links">
            <li class="nav__item"><a class="nav__link" href="#">Clients</a>
            </li>
            <li class="nav__item"><a class="nav__link" href="${pageContext.servletContext.contextPath}/EmployeeServlet">Employees</a>
            </li>
            <li class="nav__item">

                <a class="nav__link nav__link--btn btn--show-modal" href="#">Open
                    account</a>
            </li>
        </ul>
    </nav>

    <div class="header__title">
        <h1>
            When
            <!-- Green highlight effect -->
            <span class="highlight">banking</span> meets<br /> <span
                class="highlight">minimalist</span>
        </h1>
        <h4>A simpler banking experience for a simpler life.</h4>
        <button class="btn--text btn--scroll-to">Learn more
            &DownArrow;</button>
        <img src="./img/hero.png" class="header__img"
             alt="Minimalist bank items" />
    </div>
</header>

<section class="section section--sign-up">
    <div class="section__title">
        <h3 class="section__header">The best day to join Bankist was one
            year ago. The second best is today!</h3>
    </div>
    <button class="btn btn--show-modal">Open your free account
        today!</button>
</section>

<footer class="footer">
    <ul class="footer__nav">
        <li class="footer__item"><a class="footer__link" href="#">About</a>
        </li>
        <li class="footer__item"><a class="footer__link" href="#">Pricing</a>
        </li>
        <li class="footer__item"><a class="footer__link" href="#">Terms
            of Use</a></li>
        <li class="footer__item"><a class="footer__link" href="#">Privacy
            Policy</a></li>
        <li class="footer__item"><a class="footer__link" href="#">Careers</a>
        </li>
        <li class="footer__item"><a class="footer__link" href="#">Blog</a>
        </li>
        <li class="footer__item"><a class="footer__link" href="#">Contact
            Us</a></li>
    </ul>
    <img src="img/icon.png" alt="Logo" class="footer__logo" />
</footer>

</body>
</html>