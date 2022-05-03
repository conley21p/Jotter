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
<a href="HomePageServlet">Homepage</a><br>

<h1>Create Calendar</h1>
<form action="/addCalendar" method="post">
    <label for="newCalendar">New Calendar Name:</label>
    <input type="text" id="newCalendar" name="calendarName">
    <button type="submit">Create Calendar</button>
</form>
</body>
</html>
