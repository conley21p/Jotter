<%--
  Created by IntelliJ IDEA.
  User: Suraj
  Date: 5/3/2022
  Time: 5:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Free Time - Jotter</title>
</head>
<body>
<h2>Choose Time Frame:</h2>
<form action="/generateTimeSlots" method="post">
    <h4>Start Date:*</h4>
    <input type="date" name="startDate" required/>
    <h4>Start Date:*</h4>
    <input type="date" name="endDate" required/>
</form>
</body>
</html>