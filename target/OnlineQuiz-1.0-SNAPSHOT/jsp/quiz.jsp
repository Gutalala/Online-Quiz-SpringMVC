<%@ page import="DAO.quiz.Quiz" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Quiz In Progress</title>
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
                        <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
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

<div style="background-color:#DDDDDD;position:absolute; padding: 25px; width:800px; top: 175px; left: 40px; border: 1px solid green;">
    <div style="font-weight:bold;position:relative">
        <%
            int currentQuestion=((Quiz)request.getSession().getAttribute("currentQuiz")).getCurrentQuestion();
        %>
        Current Question ${sessionScope.quest.questionNumber} / ${NOQ}
    </div>
    <span style="font-weight:bold;">${sessionScope.quest.questionText}</span><br/><br/>
    <c:set var = "selected" scope = "session" value = "${sessionScope.selected}"/>
    <form action="quiz" method="post" >
        <c:forEach var="choice" items="${sessionScope.quest.answerOptions}" varStatus="counter">
            <c:choose>
                <c:when test="${counter.count == selected}">
                    <input type="radio" name="answer" value="${counter.count}" checked> ${choice}  <br/>
                </c:when>
                <c:otherwise>
                    <input type="radio" name="answer" value="${counter.count}"> ${choice} <br/>
                </c:otherwise>
            </c:choose>
        </c:forEach> <br/>

        <%
            if(currentQuestion > 0)
            {
        %>
        <input class="button quizbutton"  type="submit" name="action" value="Previous" />
        <%} %>

        <%
            if(currentQuestion < (Quiz.numberOfQuestions-1))
            {
        %>
        <input type="submit" name="action" value="Next" />
        <%} %>
        <input type="submit" name="action" value="Submit Quiz" />
    </form>
</div>

</body>
</html>