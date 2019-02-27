<%--
  Created by IntelliJ IDEA.
  User: Aliez
  Date: 17/7/18
  Time: 下午12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>detail</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Details</title>

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
<jsp:useBean id="artwork" class="entity.Artwork" scope="request"/>
<jsp:useBean id="artist" class="entity.Artist" scope="request"/>
<jsp:useBean id="genres" class="java.lang.String" scope="request"/>
<%@include file="header.jsp"%>
<div class="container margin-top-80">
<div class="container-fluid details_desc">
    <div class="row-fluid">
        <div class="col-md-10">
            <h2>${artwork.title}</h2>
            <p>By <a href="${pageContext.request.contextPath}/artist?artistId=${artist.artistId}">${artist.firstName} ${artist.lastName}</a></p>
            <div class="row-fluid">
                <div class="col-md-5">
                    <img src="./images/works/large/${artwork.imageFileName}.jpg" class="img-thumbnail img-responsive" alt="${artwork.title}"/>
                </div>
                <div class="col-md-7">
                    <div class="table-responsive panel panel-default">
                        <div class="panel-heading">
                            <span class="panel-title">Product Details</span>
                        </div>
                        <table class="table">
                            <tr>
                                <th>Date:</th>
                                <td>${artwork.yearOfWork}</td>
                            </tr>
                            <tr>
                                <th>Medium:</th>
                                <td>${artwork.medium}</td>
                            </tr>
                            <tr>
                                <th>Width:</th>
                                <td>${artwork.width}</td>
                            </tr>
                            <tr>
                                <th>Height:</th>
                                <td>${artwork.height}</td>
                            </tr>
                            <tr>
                                <th>Home:</th>
                                <td>${artwork.originalHome}</td>
                            </tr>
                            <tr>
                                <th>Genres:</th>
                                <td>${genres}</td>
                            </tr>
                            <tr>
                                <th>Subjects:</th>
                                <td>${artwork.subjects}</td>
                            </tr>
                            <tr>
                                <th>Costs:</th>
                                <td>${artwork.cost}</td>
                            </tr>
                            <tr>
                                <th>MSRP:</th>
                                <td>${artwork.msrp}</td>
                            </tr>
                            <tr>
                                <th>Artist:</th>
                                <td>${artist.firstName} ${artist.lastName}</td>
                            </tr>
                            <tr>
                                <th>Link:</th>
                                <td><a href="${artwork.artWorkLink}">${artwork.artWorkLink}</a></td>
                            </tr>
                        </table>
                    </div>
                    <c:if test="${artwork.sell==0}">
                    <div id="details_add_btn">
                        <form method="post" action="${pageContext.request.contextPath}/addToCart">
                            <input type="hidden" name="id" value="${artwork.artWorkId}">
                            <input type="hidden" name="title" value="${artwork.title}">
                            <button type="submit" class="btn btn-default">
                                <span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart
                            </button>
                        </form>
                    </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
    <div class="row-fluid" id="details_desc_text">
        <div class="col-md-8">
            <h3>Descriptions: </h3>
            <p>
                ${artwork.description}
            </p>
        </div>
    </div>
    <div class="row-fluid" id="details_share">
        <div class="col-md-8">
            <h3>Share to: </h3>
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
