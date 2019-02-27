<%--
  Created by IntelliJ IDEA.
  User: asus1
  Date: 2017/7/13
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@include file="header.jsp"%>
<div class="container margin-top-80">
    <div id="register_form">
        <form id="registerForm" class="max-width-330 layout-center">
            <h2 id="register_title">Please sign up</h2>
            <input class="form-control" id="email" type="email" name="email" placeholder="Email address" required pattern="^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})">
            <br>
            <input class="form-control" type="text" name="username" placeholder="Username" required>
            <br>
            <input class="form-control" id="password" type="password" name="password" placeholder="Password" required>
            <span id="password_desc"></span>
            <br>
            <input class="form-control" type="password" name="check_password" placeholder="Check Password" required>
            <br>
            <div class="checkbox" id="register_remember">
                <label>
                    <input type="checkbox" value="remember-me">Remember me
                </label>
            </div>
            <button type="button" class="btn btn-lg btn-primary btn-block" id="register_up">Sign up</button>
            <br>
            <a id="register_in" href="login.jsp">Sign in</a>
        </form>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="./js/bootstrap.min.js"></script>
<script src="./js/register.js"></script>

</body>
</html>
