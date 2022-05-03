<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Suraj
  Date: 5/3/2022
  Time: 3:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calendar List - Jotter</title>
</head>
<body>
<p>${error}</p>
<a href="HomePageServlet">Homepage</a><br>

<h1>Calendars</h1>
<h4>Names:</h4>
<c:forEach items="${calendars}" var="item">
    -${item} <form action="/deleteCalendar" method="post"><input type="submit"  value="Delete" name="${item}" /></form>
</c:forEach>
</body>
</html>
