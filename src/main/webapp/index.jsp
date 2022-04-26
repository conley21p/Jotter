
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <title>Homepage - Jotter</title>
</head>
<body>
<h1><%= " Today's TO-Do list" %>
</h1>
<br/>
<a href="/profile">Profile</a>
<a href="/register">Register</a>
<a href="/login">Login</a>
<a href="AddAssignmentServlet">Click To Add an Assignment</a>

<h1>Assignments</h1>
<h4>Names:</h4>
    <c:forEach items="${assignments}" var="item">
        -${item.getName()}  <form action="editAssign" method="get"><input type="submit"  value="View/Edit" name="${item.getName()}" /></form>
        <form action="/file" method="get"><input type="submit"  value="Add/View Files" name="${item.getName()}" /></form>
    </c:forEach>
</body>
</html>