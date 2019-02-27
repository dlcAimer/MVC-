<%--
  Created by IntelliJ IDEA.
  User: Aliez
  Date: 17/7/18
  Time: 下午12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search</title>
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
<jsp:useBean id="artworks" type="java.util.ArrayList<entity.Artwork>" scope="request"/>
<%@include file="header.jsp"%>
<div class="container margin-top-80">
    <div class="col-md-12 column">
        <div class="row clearfix">
            <div id="allArtists ">
                <c:if test="${artworks.size() != 0}">
                    <c:forEach var="i" begin="0" end="${artworks.size() - 1}">
                        <c:if test="${artworks.get(i).sell==0}">
                            <div style="width: 1000px;padding-left: 100px">
                                <div class="row clearfix">
                                    <div class="media">
                                        <h2 class="media-heading">${artworks.get(i).title}</h2>
                                        <a class="media-left">
                                            <img class="media-object" src="./images/works/medium/${artworks.get(i).imageFileName}.jpg" alt="${artworks.get(i).title}">
                                        </a>
                                        <div class="media-body">
                                            <p>${artworks.get(i).description}</p>
                                            <p><small>GoogleLink:<a href="${artworks.get(i).googleLink}">${artworks.get(i).googleLink}</a></small></p>
                                            <p><small>WikiLink:<a href="${artworks.get(i).artWorkLink}">${artworks.get(i).artWorkLink}</a></small></p>
                                            <p><a href="${pageContext.request.contextPath}/details?artworkId=${artworks.get(i).artWorkId}" role="button">View details</a></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </c:if>
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
