<%--
  Created by IntelliJ IDEA.
  User: noahc
  Date: 4/5/2022
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Account - Jotter</title>
</head>
<body>
<h1>Are you sure you want to delete your account?</h1>
<form action="${pageContext.request.contextPath}/AddAssignmentServlet">
    <input type="submit" value="Yes" />
</form>
<form action="${pageContext.request.contextPath}/HomePageServlet">
    <input type="submit" value="No" />
</body>
</html>
