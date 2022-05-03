<%--
  Created by IntelliJ IDEA.
  User: Suraj
  Date: 5/2/2022
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Calendar - Jotter</title>
</head>
<body>
<a href="HomePageServlet">Back to Homepage</a><br>

<h1>Enter New Calendar Name Below:</h1>
<form action="/addCalendar" method="post">
    <h4>Calendar Name:</h4>
    <label><input type="text" name="calendarName" required/></label>
    <button type="submit">Create Calendar</button>
</form>
</body>
</html>
