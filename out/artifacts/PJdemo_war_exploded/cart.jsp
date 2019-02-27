<%--
  Created by IntelliJ IDEA.
  User: 29252
  Date: 2017/7/21
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Cart</title>

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
<jsp:useBean id="carts" class="java.util.ArrayList" scope="request"/>

<c:if test="${user == null || user.customerLogon.userName == null}">
    <c:redirect url="./login.jsp"/>
</c:if>

<%@include file="header.jsp"%>

<div class="container margin-top-80">
    <div>
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" ><a href="./profile.jsp">Profile</a></li>
            <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
            <li role="presentation"><a href="${pageContext.request.contextPath}/records">Records</a></li>
            <li role="presentation"><a href="./settings.jsp">Settings</a></li>
        </ul>
        <!-- Tab panes -->
        <div>
            <div  class="tab-pane" id="cart">
                <form action="${pageContext.request.contextPath}/buy" method="post">
                <table class="table table-striped">
                    <tr>
                        <td>Selecte</td>
                        <td>OrderId</td>
                        <td>DateCreate</td>
                        <td>Artwork</td>
                        <td>Class</td>
                        <td></td>
                    </tr>
                    <%--<c:if test="${requestScope.get('carts')>0}">--%>
                        <%--<td>${carts.size()}</td>--%>
                    <c:if test="${carts.size()>0}">
                        <c:forEach var="i" begin="0" end="${carts.size()-1}">
                            <tr>
                                <%--@elvariable id="getOne" type=""--%>
                                <td><input type="checkbox" name="${carts.get(i).orderId}" value="${carts.get(i).orderId}">
                                <td>${carts.get(i).orderId}</td>
                                <td>${carts.get(i).dateCreate}</td>
                                <td>${carts.get(i).artworkTitle}</td>
                                <td>non-payment</td>
                                <td><button><a href="deleteCart?id=${carts.get(i).orderId}">DELETE</a></button></td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <tr>
                        <td></td><td></td>
                        <td><input type="submit" value="Buy"></td>--%>
                        <td></td><td></td>
                    </tr>
                </table>
                </form>
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
