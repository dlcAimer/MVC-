<%@ page import="entity.Customers" %>
<%@ page import="entity.CustomerLogon" %>
<%--
  Created by IntelliJ IDEA.
  User: Aliez
  Date: 17/7/15
  Time: 下午10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <img src="./images/图片%201.png" width="45" height="38" >
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="./">Artworks</a></li>
                <li><a href="${pageContext.request.contextPath}/artists">Artists</a> </li>
                <% if (session.getAttribute("user") == null) {%>
                <li><a href="./login.jsp">Sign in</a></li>
                <li><a href="./register.jsp">Sign up</a></li>
                <% }else {
                    CustomerLogon customer= ((Customers)session.getAttribute("user")).getCustomerLogon();
                %>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">
                        <%=customer.getUserName()%><span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">Basic</li>
                        <li><a href="profile.jsp">Your Profile</a></li>
                        <li><a href="${pageContext.request.contextPath}/cart">Your Cart</a></li>
                        <li><a href="${pageContext.request.contextPath}/records">Your Records</a></li>
                        <li class="divider" role="separator"></li>
                        <li class="dropdown-header">Others</li>
                        <li><a href="./settings.jsp">Settings</a></li>
                        <li><a href="${pageContext.request.contextPath}/signout">Sign out</a></li>
                    </ul>
                </li>
                <% }%>
            </ul>

            <form class="navbar-form navbar-right" action="${pageContext.request.contextPath}/search" method="get">
                <input type="search" class="form-control" placeholder="To search" name="keyword">
                <label>
                    <select class="form-control" name="searchBy">
                        <option value="Title" selected>Title</option>
                        <option value="Description">Description</option>
                        <option value="Artist">Artist</option>
                    </select>
                </label>
                <label>
                    <select class="form-control" name="sortBy">
                        <option value="Cost">Cost</option>
                        <option value="YearOfWork">Date</option>
                    </select>
                </label>
                <input type="submit" class="btn btn-success" value="Search!">
            </form>
        </div>
    </div>
</nav>
