<%--
  Created by IntelliJ IDEA.
  User: Jacob Radtke
  Date: 4/30/2022
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Import Calendar - Jotter</title>
</head>
<body>
<h1>Do you want to add another calendar?</h1>
<form action="${pageContext.request.contextPath}/ImportCalendar">
    <input type="submit" value="Yes" />
</form>
<form action="${pageContext.request.contextPath}/profile">
    <input type="submit" value="No" />
</form>


</body>
</html>
