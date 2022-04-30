<%--
  Created by IntelliJ IDEA.
  User: Jacob Radtke
  Date: 4/6/2022
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Import Calendar</title>
</head>
<body>

<p>${message}</p>

<h1>Calendar</h1>
<a href="HomePageServlet">Back to Homepage</a><br><br>
<form action="/ImportCalendar" method="post" enctype="multipart/form-data">

    <label for="newCal">Upload Calendar:</label>
    <input type="file" id="newCal" name="newCal" accept=".txt">
    <button type="submit" name="decision" value="importCal">Import Calendar</button><br><br><br><br>
</form>

</form>
</body>
</html>