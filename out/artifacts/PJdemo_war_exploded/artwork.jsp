<%@ page import="entity.Artwork" %>
<%--
  Created by IntelliJ IDEA.
  User: 29252
  Date: 2017/7/26
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="pageService" class="service.impl.PageServiceImpl" scope="request"/>

<% int pageNum = Integer.parseInt (request.getParameter ("page")); %>
<% int pageSize = 10; %>
<% int numOfPages = pageService.totalPage(pageSize); %>
<%
    if(pageNum > numOfPages) pageNum = numOfPages;
    if(pageNum < 1) pageNum = 1;
%>
<% for (Artwork artwork : pageService.getByPage(pageNum,pageSize)){ %>
<div style="width: 1400px;padding-left: 100px">
<div class="row clearfix">
    <div class="media">
        <h2 class="media-heading"><%=artwork.getTitle ()%></h2>
        <a class="media-left">
            <img class="media-object" src="./images/works/medium/<%=artwork.getImageFileName()%>.jpg" alt="<%=artwork.getTitle()%>">
        </a>
        <div class="media-body">
            <p><%=artwork.getDescription()%></p>
            <p><small>GoogleLink:<a href="<%=artwork.getGoogleLink()%>"><%=artwork.getGoogleLink()%></a></small></p>
            <p><small>WikiLink:<a href="<%=artwork.getArtWorkLink()%>"><%=artwork.getArtWorkLink()%></a></small></p>
            <p><a href="${pageContext.request.contextPath}/details?artworkId=<%=artwork.getArtWorkId()%>" role="button">View details</a></p>
        </div>
    </div>
</div>
</div>
<% } %>

<div class="row text-center">
    <ul class="pagination pagination-sm" id="pagination">
        <li><a id="lastPage" <%= pageNum == 1 ? "class='invisible'" : ""%>>&larr;</a></li>
        <!--以十页为分栏-->
        <% if (numOfPages <= 10) { %>
        <% for (int i = 1; i <= numOfPages; i++) { %>
        <li <% out.print(i == pageNum ? "class='active'" : ""); %> data-pageNum=<%=i%> ><a><%=i%></a></li>
        <% } %>
        <% }else { %>
        <% if (pageNum <= 5) { %>
        <% for (int i = 1; i <= 10; i++) { %>
        <li <% out.print(i == pageNum ? "class='active'" : ""); %> data-pageNum=<%=i%> ><a><%=i%></a></li>
        <% } %>
        <% }else if (pageNum > 5 && pageNum <= numOfPages - 5) { %>
        <% for (int i = pageNum - 4; i < pageNum + 6; i++) { %>
        <li <% out.print(i == pageNum ? "class='active'" : ""); %> data-pageNum=<%=i%> ><a><%=i%></a></li>
        <% } %>
        <% }else if (pageNum > numOfPages - 5) { %>
        <% for (int i = numOfPages - 9; i <= numOfPages; i++) { %>
        <li <% out.print(i == pageNum ? "class='active'" : ""); %> data-pageNum=<%=i%> ><a><%=i%></a></li>
        <% } %>
        <% } %>
        <% } %>
        <li><a id="nextPage" <%= pageNum == numOfPages ? "class='invisible'" : ""%>>&rarr;</a></li>
    </ul>
</div>


