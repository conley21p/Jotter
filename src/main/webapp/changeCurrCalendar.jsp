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
    <c:forEach items="${calendar}" var="item">
        -${item.getName()}  <form action="makeCurr" method="get"><input type="submit"  value="makeCurr" name="${item.getName()}" /></form>
    </c:forEach>
</body>
</html>
