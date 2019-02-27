<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
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
<div>
    <form id="login_form" class="max-width-330 layout-center" action="${pageContext.request.contextPath}/login" method="post">
        <h2 id="login_title">Please sign in</h2>
        <input class="form-control" type="text" name="username" placeholder="Enter username">
        <br>
        <input class="form-control" type="password" name="password" placeholder="Enter password">
        <br>
        <div class="checkbox" id="login_remember">
            <label>
                <input type="checkbox" value="remember-me">Remember me
            </label>
        </div>
        <button id="login_in" class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
        <br>
        <a id="login_up" href="./register.jsp">Sign up</a>
        </form>
</div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="./js/bootstrap.min.js"></script>
<script src="./js/login.js"></script>

</body>
</html>
