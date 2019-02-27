<%--
  Created by IntelliJ IDEA.
  User: Aliez
  Date: 17/7/17
  Time: 下午6:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArtWorks</title>
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
<jsp:useBean id="heat" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="fresh" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="all" class="java.util.ArrayList" scope="request"/>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/header.jsp"%>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <c:forEach var="i" begin="0" end="2">
        <c:if test="${i == 0}"><div class="item active"></c:if>
        <c:if test="${i != 0}"><div class="item"></c:if>
            <img class="home_big_img mostHot" src="./images/works/large/${heat.get(i).imageFileName}.jpg" alt="${heat.get(i).imageFileName}">
            <div class="carousel-caption">
                <h3>${heat.get(i).title}</h3>
                <p>${heat.get(i).excerpt}</p>
                <a href="details?artworkId=${heat.get(i).artWorkId}"><button class="home_btn_see_details">See Details</button></a>
            </div>
        </div>
        </c:forEach>
    </div>
    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
</div>

    <div class="col-md-12 column">
        <div class="row clearfix">
            <c:forEach var="i" begin="0" end="2">
                <div class="col-md-4 column">
            <div class="">
                <a href="details?artworkId=${fresh.get(i).artWorkId}"><img class="img-circle" src="./images/works/small/${fresh.get(i).imageFileName}.jpg" ></a>
            </div>
            <div class="">
                <a href="#"><h5 class=""><b>${fresh.get(i).title}</b></h5></a>
                <label>
                    <p class="home_desc_for_small_img" readonly>${fresh.get(i).description}</p>
                </label>
                    <%--<p>The Portrait of Eleanor of Toledo and Her Son is apainting by the Italian artist Agnolo di Cosimo, knownas Bronzino, finished ca, 1545. One of his mostfamous works, it is housed in the Uffizi Gallery ofFlorence, Italy and is considered one of thepreeminent examples of Mannerist portraiture.</p>--%>
            </div>
            <div class="home_view_btn">
                <a  href="details?artworkId=${fresh.get(i).artWorkId}"><button type="button" class="button bt-view" onclick="">View details <span class="fa fa-angle-right"></span><span class="fa fa-angle-right"></span></button></a>
            </div>
        </div>
            </c:forEach>
            </div>
        </div>

<div id="allArtworks">
    <div>loading...</div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/page.js"></script>
</body>
</html>
