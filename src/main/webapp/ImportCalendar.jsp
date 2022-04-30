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
    <title>Profile - Jotter</title>
</head>
<body>

<p>${message}</p>

<h1>Profile</h1>
<a href="HomePageServlet">Back to Homepage</a><br><br>
<form enctype="multipart/form-data" action="/upload/image" method="post">

    <label for="newCal">Upload Calendar:</label>
    <input type="file" id="newCal" name="newCal" accept=".txt">
    <button type="submit" name="decision" value="changePassword">Change Password</button><br><br><br><br>
</form>
<a href="/ImportCalendarServlet">Import a Calendar</a><br>

</form>
</body>
</html>