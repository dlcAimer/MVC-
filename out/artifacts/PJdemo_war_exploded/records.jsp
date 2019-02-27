<%--
  Created by IntelliJ IDEA.
  User: 29252
  Date: 2017/7/21
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Records</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>LoginPage</title>
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

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="entity.Customers" scope="session"/>
<jsp:useBean id="orders" class="java.util.ArrayList" scope="session"/>


<c:if test="${user == null || user.customerLogon.userName == null}">
    <c:redirect url="./login.jsp"/>
</c:if>

<%--<c:when test="${requestScope.get('orders')==null}">--%>
    <%--<jsp:forward page="/records"/>--%>
<%--</c:when>--%>

<%@include file="header.jsp"%>
<div class="container margin-top-80">
    <div>
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" ><a href="./profile.jsp">Profile</a></li>
            <li role="presentation"><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
            <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/records">Records</a></li>
            <li role="presentation"><a href="./settings.jsp">Settings</a></li>
        </ul>
        <!-- Tab panes -->
        <div >
            <div class="tab-pane" id="records">
                <table class="table table-striped">
                    <tr>
                        <td>OrderId</td>
                        <td>DateCreate</td>
                        <td>DateCompleted</td>
                        <td>Artwork</td>
                        <td>Class</td>
                    </tr>
                    <c:if test="${orders.size() > 0}">
                        <c:forEach var="i" begin="0" end="${orders.size() - 1}">
                            <tr>
                                <td>${orders.get(i).onesorderId}</td>
                                <td>${orders.get(i).dateCreate}</td>
                                <td>${orders.get(i).dateCompleted}</td>
                                <td>${orders.get(i).artWorkTitle}</td>
                                <td>Clear</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
