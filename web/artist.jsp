<%--
  Created by IntelliJ IDEA.
  User: 29252
  Date: 2017/7/21
  Time: 6:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artist</title>
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
<jsp:useBean id="artist" class="entity.Artist" scope="request"/>
<jsp:useBean id="works" class="java.util.ArrayList" scope="request"/>
<%@include file="header.jsp"%>
<div class="container margin-top-80">
<div class="container-fluid details_desc">
    <div class="row-fluid">
        <div class="col-md-10">
            <h2>${artist.firstName} ${artist.lastName}</h2>
            <div class="row-fluid">
                <div class="col-md-5">
                    <img src="./images/artists/medium/${artist.artistId}.jpg" class="img-thumbnail img-responsive" alt="${artist.firstName} ${artist.lastName}"/>
                </div>
                <div class="col-md-7">
                    <div class="table-responsive panel panel-default">
                        <div class="panel-heading">
                            <span class="panel-title">Artist Details</span>
                        </div>
                        <table class="table">
                            <tr>
                                <th>YearOfBorth:</th>
                                <td>${artist.yearOfBirth}</td>
                            </tr>
                            <tr>
                                <th>YearOfDeath:</th>
                                <td>${artist.yearOfDeath}</td>
                            </tr>
                            <tr>
                                <th>National:</th>
                                <td>${artist.nationality}</td>
                            </tr>
                            <tr>
                                <th>link:</th>
                                <td><a href="${artist.artistLink}">${artist.artistLink}</a></td>
                            </tr>
                            <tr>
                                <th>Artworks:</th>
                                <td>
                                    <c:forEach var="i" begin="0" end="${works.size() - 1}">
                                        <a href="${pageContext.request.contextPath}/details?artworkId=${works.get(i).artWorkId}">${works.get(i).title}</a>
                                        <br>
                                    </c:forEach>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row-fluid" id="details_desc_text">
        <div class="col-md-8">
            <h3>Descriptions: </h3>
            <p>
                ${artist.details}
            </p>
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
