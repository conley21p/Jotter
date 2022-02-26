<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <title>JOTTER!!</title>
</head>
<body>
<h1><%= " Today's TO-Do list" %>
</h1>
<br/>
<a href="AddAssignmentServlet">Click To Add an Assignment</a>

<h1>Assignments</h1>
Names:
<c:forEach items="${assignments}" var="item">
    -${item.getName()}<br>
</c:forEach>
<table>
</table>


</body>
</html>