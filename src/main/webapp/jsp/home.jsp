<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <!-- load stylesheets -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">

    <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="../fontawesome-free-5.15.3-web/css/all.css">
<%--    <!-- Font Awesome -->--%>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
<%--    <!-- Bootstrap style -->--%>
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
        <a style="color: black" href='${pageContext.request.contextPath}/resultdetails'>
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
                        <a class="nav-link" href="/contact">Contact Us</a>
                    </li>
                </ul>
            </div>
        </div>

    </nav>
</div>

<ul class="cd-hero-slider">

    <!-- Page 1 Home -->
    <li class="selected">
        <div class="cd-full-width">
            <div class="container-fluid js-tm-page-content tm-page-pad" data-page-no="1">
                <div class="row">
                    <div class="tm-3-col-container">
                        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 tm-3-col-textbox">
                            <div class="text-xs-left tm-textbox tm-textbox-padding tm-bg-white-translucent tm-3-col-textbox-inner">
                                <i class="fa fa-4x fa-laptop-code tm-home-fa"></i>
                                 <h2 class="tm-text-title"><a href ="takeQuiz?category=java">Java </a></h2>
                                <p class="tm-text"> 10 multiple choice questions to test your knowledge in Java. The Time Limit is 15 minutes. Answer 6 questions correctly to pass. Are you ready?  </p>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 tm-3-col-textbox">
                            <div class="text-xs-left tm-textbox tm-textbox-padding tm-bg-white-translucent tm-3-col-textbox-inner">
                                <i class="fa fa-4x fa-theater-masks tm-home-fa"></i>
                                <h2 class="tm-text-title"><a href ="takeQuiz?category=art">Art</a></h2>
                                <p class="tm-text"> 10 multiple choice questions to test your knowledge in all Art forms. The Time Limit is 15 minutes. Answer 6 questions correctly to pass. Are you ready? </p>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 tm-3-col-textbox">
                            <div class="text-xs-left tm-textbox tm-textbox-padding tm-bg-white-translucent tm-3-col-textbox-inner">
                                <i class="fa fa-4x fa-landmark tm-home-fa"></i>
                                <h2 class="tm-text-title"><a href ="takeQuiz?category=politic">Political Science</a></h2>
                                <p class="tm-text">10 multiple choice questions to test your knowledge in Politics. The Time Limit is 15 minutes. Answer 6 questions correctly to pass. Are you ready? </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </li>
</ul>

</body>
</html>