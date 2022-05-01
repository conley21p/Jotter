<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jacob Radtke
  Date: 4/30/2022
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calendars Available - Jotter</title>
</head>
<body>
<a href="HomePageServlet">Back to Homepage</a><br><br>

<h1>Calendars Available</h1>
<h4>Names:</h4>
<c:forEach items="${calendars}" var="item">
    -${item.getName()} <form action="makeCurrCal" method="post"><input type="submit"  value="Make Current" name="${item.getName()}" /></form>
</c:forEach>
</body>
</html>
