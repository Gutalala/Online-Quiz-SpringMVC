<%@ page import="DAO.quiz.Quiz" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Quiz Result</title>
    <!--
    Upper Template
    http://www.templatemo.com/tm-497-upper
    -->
    <!-- load stylesheets -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">
    <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="../fontawesome-free-5.15.3-web/css/all.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <!-- Bootstrap style -->
    <link rel="stylesheet" href="../css/hero-slider-style.css">
    <!-- Hero slider style (https://codyhouse.co/gem/hero-slider/) -->

    <link rel="stylesheet" href="../css/templatemo-style.css">
    <!-- Templatemo style -->


    <style>
        td {
            padding: 20px;
        }
    </style>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:if test='${not empty sessionScope.username}'>
        <div style="background-color: transparent;">
            <a style="color: black" href='${pageContext.request.contextPath}/userPanel'>
                &nbsp;Hello, ${sessionScope.full_name}
            </a>

            <a href='${pageContext.request.contextPath}/logout' style="float: right; color: black">
                Log Out ? &nbsp;
            </a>
        </div>
    </c:if>

</head>

<body>
<!-- Navigation -->
<div class="cd-slider-nav">
    <nav class="navbar">
        <div class="tm-navbar-bg">

            <a class="navbar-brand text-uppercase" href="#"><i class="fa fa-flash tm-brand-icon"></i>Casper Quiz</a>

            <button class="navbar-toggler hidden-lg-up" type="button" data-toggle="collapse" data-target="#tmNavbar">
                &#9776;
            </button>
            <div class="collapse navbar-toggleable-md text-xs-center text-uppercase tm-navbar" id="tmNavbar">
                <ul class="nav navbar-nav">
                    <li class="nav-item active selected">
                        <a class="nav-link" href="">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/register">Registration</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/jsp/feedback.jsp">Feedback</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="https://www.google.com" >Contact Us</a>
                    </li>
                </ul>
            </div>
        </div>

    </nav>
</div>

<ul class="cd-hero-slider"></ul>

<div style="background-color:transparent; width: 1000px; position: absolute; left: 50%; top: 40%; padding: 50px; transform: translate(-50%, -50%);">
    <div style="width: 70%; float: left;">
    <h3 align="center">Quiz Result</h3>
    <table align="center" border=1>
        <tr>
            <td>Quiz :</td>
            <td><span>${sessionScope.quizName}</span></td>
        </tr>

        <tr>
            <td>User :</td>
            <td><span>${sessionScope.full_name}</span></td>
        </tr>

        <tr>
            <td>Start Time :</td>
            <td><span>${sessionScope.start_time}</span></td>
        </tr>
        <tr>
            <td>End Time :</td>
            <td><span>${sessionScope.ended}</span></td>
        </tr>


        <tr>
            <td>Number of Questions :</td>
            <td><span>10</span></td>
        </tr>

        <tr>
            <td>Number of correct answers :</td>
            <td><span>${requestScope.result}</span></td>
        </tr>

    </table>
    </div>
    <div style="margin-left: 30%;">
        <br> <br>
        <c:if test="${requestScope.result >= 6}">
            <h1 class="font-weight-bold" style="color: green">Congratulations! You Passed!</h1>
        </c:if>
        <c:if test="${requestScope.result < 6}">
            <h1 class="font-weight-bold" style="color: red">You Did Not Pass</h1>
        </c:if>
        <br><br>
        <form action="${pageContext.request.contextPath}/home" method="get">
            <button type="submit" class="btn btn-primary btn-lg">Try Another Quiz?</button>
        </form>
    </div>
</div>

</body>
</html>
