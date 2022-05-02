
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <title>Homepage - Jotter</title>
</head>
<body>
<a href="/login">Logoff</a><br>
<a href="/history">Assignment History</a><br>
<a href="/ImportCalendar">Import Calendar</a><br>
<a href="/ChangeCurrCalendar">Change Calendar</a><br>
<a href="/profile">Edit Profile</a><br>
<a href="/Analytic">Analytics</a><br>
<h1><%= " Today's TO-Do list" %>
</h1>
<h1>Assignments</h1>
<a href="AddAssignmentServlet">Click To Add an Assignment</a><br>
<h4>Names:</h4>
    <c:forEach items="${assignments}" var="item">
        -${item.getName()} ${item.getCourse()}  <form action="editAssign" method="get"><input type="submit"  value="View/Edit" name="${item.getName()}" /></form>
        <form action="/UploadFile" method="get"><input type="submit"  value="Upload File" name="${item.getName()}" /></form>
    </c:forEach>
</body>
</html>