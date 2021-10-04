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

    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">

    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>

   <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>

    <script>
        $(document).ready( function () {
            $('#table_id').DataTable({
                searching: true,
                paging: true,
                info: true,
                iDisplayLength: 20
            });
        } );
    </script>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
                        <a class="nav-link" href="/user_list">User List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/question_list">Question List</a>
                    </li>
                </ul>
            </div>
        </div>

    </nav>
</div>

<ul class="cd-hero-slider">
    <div style="background-color:transparent; position: absolute; left: 50%; top: 50%; padding: 10px; transform: translate(-50%, -50%);">
    <table id="table_id" class="display">
        <thead>
        <tr>
            <th>Taken_Date</th>
            <th>Category</th>
            <th>User Full Name</th>
            <th>No. of Questions</th>
            <th>Score</th>
        </tr>
        </thead>
        <tbody>
        <C:forEach var="quiz" items="${requestScope.quizzes}" varStatus="counter">
            <tr>
                <c:set value="${quiz.startTime}" var="dateString" />
                <fmt:parseDate value="${dateString}" var="dateObject"
                               pattern="yyyy-MM-dd HH:mm:ss" />
                <td><fmt:formatDate value="${dateObject}" pattern="dd/MM/yyyy"/></td>
                <td>${quiz.category}</td>
                <td>${quiz.usersHB.fullName}</td>
                <td>10</td>
                <td>${quiz.score}</td>
            </tr>
        </C:forEach>
        </tbody>
    </table>
    </div>
</ul>

</body>
</html>