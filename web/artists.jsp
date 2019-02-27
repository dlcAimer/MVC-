<%--
  Created by IntelliJ IDEA.
  User: Aliez
  Date: 17/7/18
  Time: 下午12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artists</title>
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
<jsp:useBean id="artists" type="java.util.ArrayList<entity.Artist>" scope="request"/>
<jsp:useBean id="works" type="java.util.ArrayList<java.util.ArrayList<entity.Artwork>>" scope="request"/>

<%@include file="header.jsp"%>
<h3 id="allArtists_title" class="row">Artists</h3>
<div class="col-md-12 column">
    <div class="row clearfix" >
        <div id="allArtists ">
            <c:if test="${artists.size() != 0}">
                <c:forEach var="i" begin="0" end="${artists.size() - 1}">
                    <div class="col-md-4 column" style="height: 1000px;width: 500px">
                        <div id="artist" class="">
                            <table >
                                <tr>
                                    <td><a href="${pageContext.request.contextPath}/artist?artistId=${artists.get(i).artistId}"><img class="allArtists_small_img" src="./images/artists/small/${artists[i].artistId}.jpg" alt=""></a></td>
                                </tr>
                                <tr>
                                    <td>${artists.get(i).firstName} ${artists.get(i).lastName}</td>
                                </tr>
                                <tr>
                                    <td>Artist Link:<a href="${pageContext.request.contextPath}/artist?artistId=${artists.get(i).artistLink}">${artists.get(i).artistLink}</a></td>
                                </tr>
                                <tr>
                                    <td>${artists.get(i).details}</td>
                                </tr>
                            </table>
                            Artworks:
                            <ol>
                                <c:forEach var="j" begin="0" end="${works.get(i).size() - 1}">
                                    <li><a href="${pageContext.request.contextPath}/details?artworkId=${works.get(i).get(j).artWorkId}">${works.get(i).get(j).title}</a></li>
                                </c:forEach>
                            </ol>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
