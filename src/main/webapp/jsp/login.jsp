<%--
  Created by IntelliJ IDEA.
  User: Galahad
  Date: 6/25/2021
  Time: 4:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
    <style type="text/css">
        @import "bourbon";

        body {
            background: #eee !important;
        }

        .wrapper {
            margin-top: 80px;
            margin-bottom: 80px;
        }

        .form-signup {
            max-width: 380px;
            padding: 15px 35px 45px;
            margin: 0 auto;
            background-color: #fff;
            border: 1px solid rgba(0,0,0,0.1);
        }

        .form-signup-heading,
        .checkbox {
            margin-bottom: 30px;
        }

        .checkbox {
            font-weight: normal;
        }

        .form-control {
            position: relative;
            font-size: 16px;
            height: auto;
            padding: 10px;
            @include box-sizing(border-box);

        &:focus {
             z-index: 2;
         }
        }

        input[type="text"] {
            margin-bottom: -1px;
            border-bottom-left-radius: 0;
            border-bottom-right-radius: 0;
        }

        input[type="password"] {
            margin-bottom: 20px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

    </style>
</head>
<body>
<div class="wrapper">
    <form class="form-signup" action="/checkLogin" method="POST">
        <h2 class="form-signup-heading">Login</h2>
        <br>
        <input type="text" class="form-control" id="txtUser" name="username" placeholder="Username" required="" autofocus="" />
        <input type="password" class="form-control" id="txtPassword" name="password" placeholder="Password" required=""/>
<%--        <label class="checkbox">--%>
<%--            <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me--%>
<%--        </label>--%>
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login"/>
        <br>
        Or <a href="/register">Sign up</a> for a new account.
    </form>
</div>
</body>
</html>
