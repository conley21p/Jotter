<%--
  Created by IntelliJ IDEA.
  User: conle
  Date: 2/25/2022
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Assignment</title>
</head>
<body>
<h1>Enter new assignment Below:</h1>
<form action="AddAssignmentServlet" method="post">
    <h4>Name:</h4><input type="text" name="name" />
    <h4>Date:</h4><input type="date" name="date" />
    <h4>Time:</h4><input type="time" name="time" />
    <h4>description:</h4><input type="text" name="description" />
    <h4></h4><input type="submit" />
</form>
</body>
</html>
